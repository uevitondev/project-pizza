package com.uevitondev.mspizza.services.auth;

import com.uevitondev.mspizza.dtos.ResponseLoginDTO;
import com.uevitondev.mspizza.dtos.UserCredentialsDTO;
import com.uevitondev.mspizza.dtos.UserRegistrationDTO;
import com.uevitondev.mspizza.entities.ConfirmationToken;
import com.uevitondev.mspizza.entities.User;
import com.uevitondev.mspizza.exceptions.DatabaseException;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.RoleRepository;
import com.uevitondev.mspizza.repositories.UserRepository;
import com.uevitondev.mspizza.services.ConfirmationTokenService;
import com.uevitondev.mspizza.services.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailService emailService;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, JwtService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, ConfirmationTokenService confirmationTokenService, EmailService emailService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.confirmationTokenService = confirmationTokenService;
        this.emailService = emailService;
    }

    @Transactional
    public ResponseLoginDTO signup(UserRegistrationDTO dto) {
        try {
            var role = roleRepository.findByAuthority("CLIENT").orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
            User user = new User();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setEnabled(false);
            user.getRoles().add(role);
            var userSave = userRepository.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(userSave);
            confirmationToken = confirmationTokenService.saveConfirmationToken(confirmationToken);
            String link = "http://localhost:8080/auth/signup/confirmation?token=" + confirmationToken.getToken();
            String emailContent = emailService.defaultTemplateAccountConfirmation(link, user.getFirstName());
            emailService.sendEmailTokenRegistration(user.getEmail(), emailContent);

            return new ResponseLoginDTO(confirmationToken.getToken());
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Usuário já cadastrado!");
        }
    }


    @Transactional
    public String signupConfirmation(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getConfirmationToken(token).orElseThrow(() -> new ResourceNotFoundException("token not found"));
        if (confirmationToken.getConfirmedAt() != null) {
            return "Email already confirmed!";
        }
        if (confirmationToken.getExpiredAt().isBefore(LocalDateTime.now())) {
            return "Token Expired!";
        }
        confirmationTokenService.updateConfirmedAt(confirmationToken.getId());
        User user = userRepository.getReferenceById(confirmationToken.getUser().getId());
        user.setEnabled(true);
        userRepository.save(user);

        return "sua conta foi ativada com sucesso!";
    }

    public ResponseLoginDTO signin(UserCredentialsDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        var user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Bad Credentials!"));
        var jwt = jwtService.generateToken(user);
        return new ResponseLoginDTO(jwt);
    }


}