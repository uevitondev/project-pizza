package com.uevitondev.mspizza.services.auth;

import com.uevitondev.mspizza.dtos.ResponseLoginDTO;
import com.uevitondev.mspizza.dtos.UserLoginDTO;
import com.uevitondev.mspizza.entities.User;
import com.uevitondev.mspizza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public ResponseLoginDTO login(UserLoginDTO userLoginDTO) {
        var user = new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        var auth = authenticationManager.authenticate(user);
        var userAuth = (User) auth.getPrincipal();
        var token = jwtService.generateToken(userAuth);
        return new ResponseLoginDTO(token);

    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByEmail(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Bad Credentials!"));
    }
}
