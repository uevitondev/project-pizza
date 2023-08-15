package com.uevitondev.mspizza.controllers;

import com.uevitondev.mspizza.dtos.ResponseLoginDTO;
import com.uevitondev.mspizza.dtos.UserLoginDTO;
import com.uevitondev.mspizza.services.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<ResponseLoginDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok().body(authService.login(userLoginDTO));
    }
}
