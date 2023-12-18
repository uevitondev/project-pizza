package com.uevitondev.mspizza.controllers;

import com.uevitondev.mspizza.dtos.ResponseLoginDTO;
import com.uevitondev.mspizza.dtos.UserCredentialsDTO;
import com.uevitondev.mspizza.dtos.UserRegistrationDTO;
import com.uevitondev.mspizza.services.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseLoginDTO> signup(@RequestBody UserRegistrationDTO dto) {
        return ResponseEntity.ok().body(authService.signup(dto));
    }

    @GetMapping("/signup/confirmation")
    public ResponseEntity<String> signupConfirmation(@RequestParam String token) {
        return ResponseEntity.ok().body(authService.signupConfirmation(token));
    }


    @PostMapping("/signin")
    public ResponseEntity<ResponseLoginDTO> signin(@RequestBody UserCredentialsDTO dto) {
        return ResponseEntity.ok().body(authService.signin(dto));
    }


}
