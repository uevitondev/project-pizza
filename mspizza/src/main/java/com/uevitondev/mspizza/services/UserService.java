package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.UserDTO;
import com.uevitondev.mspizza.entities.User;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> new UserDTO(user))
                .toList();

    }

    @Transactional
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found, for id: " + id));
        return new UserDTO(user);
    }

}
