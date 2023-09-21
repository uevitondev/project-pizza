package com.uevitondev.mspizza.services;

import com.uevitondev.mspizza.dtos.UserDTO;
import com.uevitondev.mspizza.entities.Role;
import com.uevitondev.mspizza.entities.User;
import com.uevitondev.mspizza.exceptions.DatabaseException;
import com.uevitondev.mspizza.exceptions.ResourceNotFoundException;
import com.uevitondev.mspizza.repositories.RoleRepository;
import com.uevitondev.mspizza.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).toList();

    }

    @Transactional(readOnly = true)
    public UserDTO findUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found, for id: " + id));
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insertNewUser(UserDTO dto) {

        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        for (Long roleId : dto.getRolesId()) {
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new ResourceNotFoundException("role not found, for id: " + roleId));
            user.getRoles().add(role);
        }
        user = userRepository.save(user);

        return new UserDTO(user);
    }

    @Transactional
    public UserDTO updateUserById(Long id, UserDTO dto) {
        try {
            User user = userRepository.getReferenceById(id);
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setEmail(dto.getEmail());
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.getRoles().clear();

            for (Long roleId : dto.getRolesId()) {
                Role role = roleRepository.findById(roleId)
                        .orElseThrow(() -> new ResourceNotFoundException("role not found, for id: " + roleId));
                user.getRoles().add(role);
            }

            user = userRepository.save(user);
            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("user not found, for id: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("user not found, for id: " + id);
        }
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Referential integrity constraint violation");
        }
    }
}
