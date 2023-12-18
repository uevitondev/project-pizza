package com.uevitondev.mspizza.services.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.uevitondev.mspizza.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    @Value("${my.secret.client}")
    private String mySecretClient;

    @Value("${my.secret.key}")
    private String mySecretKey;


    public String generateToken(User user) {
        return JWT
                .create()
                .withIssuer(mySecretClient)
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() * 1000 * 60 * 24))
                .sign(Algorithm.HMAC256(mySecretKey));
    }

    public String extractSubject(String token) {
        return JWT
                .require(Algorithm.HMAC256(mySecretKey))
                .withIssuer(mySecretClient)
                .build()
                .verify(token)
                .getSubject();
    }


}