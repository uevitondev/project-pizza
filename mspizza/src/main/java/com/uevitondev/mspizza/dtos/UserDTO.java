package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
    private Long id;
    @NotBlank(message = "Não pode ser vazio!")
    private String firstName;
    @NotBlank(message = "Não pode ser vazio!")
    private String lastName;
    @NotBlank(message = "Não pode ser vazio!")
    @Email(message = "Endereço de email incorreto!")
    private String email;
    @NotBlank(message = "Não pode ser vazio!")
    private String password;
    private List<Long> rolesId = new ArrayList<>();

    public UserDTO() {

    }

    public UserDTO(Long id, String firstName, String lastName, String email, String password, List<Long> rolesId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rolesId = rolesId;
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        user.getRoles().stream().map(role -> this.rolesId.add(role.getId())).toList();
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

    public List<Long> getRolesId() {
        return rolesId;
    }

    public void setRolesId(List<Long> rolesId) {
        this.rolesId = rolesId;
    }
}
