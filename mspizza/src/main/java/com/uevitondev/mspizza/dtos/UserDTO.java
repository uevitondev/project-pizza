package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Role;
import com.uevitondev.mspizza.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {
    private Long id;
    @NotBlank(message = "firstName: is mandatory")
    private String firstName;
    @NotBlank(message = "lastName: is mandatory")
    private String lastName;
    @NotBlank(message = "email: is mandatory")
    @Email(message = "email: is invalid")
    private String email;
    @NotBlank(message = "password: is mandatory")
    private String password;

    @NotEmpty(message = "rolesId: is empty")
    private final Set<Long> rolesId = new HashSet<>();

    public UserDTO() {

    }

    public UserDTO(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public UserDTO(User user, Set<Role> roles) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        roles.forEach(role -> this.rolesId.add(role.getId()));
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Long> getRolesId() {
        return rolesId;
    }
}
