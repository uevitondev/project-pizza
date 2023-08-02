package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dto.UserLoginDTO;
import com.uevitondev.mspizza.entities.User;
import com.uevitondev.mspizza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    public String login(UserLoginDTO userLoginDTO) {
        var user = new UsernamePasswordAuthenticationToken(userLoginDTO.getEmail(), userLoginDTO.getPassword());
        var auth = authenticationManager.authenticate(user);
        var userAuth = (User) auth.getPrincipal();
        return jwtService.generateToken(userAuth);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository.findByEmail(userName);
    }
}
