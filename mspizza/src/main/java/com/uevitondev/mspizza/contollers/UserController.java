package com.uevitondev.mspizza.contollers;

import com.uevitondev.mspizza.entities.User;
import com.uevitondev.mspizza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        User user1 = new User(1L, "ueviton", "santos", "ueviton@gmail.com", "12345");
        User user2 = new User(1L, "ueviton", "santos", "ueviton@gmail.com", "12345");
        List<User> listUsers = Arrays.asList(user1, user2);
        return ResponseEntity
                .ok()
                .body(listUsers);
    }
}
