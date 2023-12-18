package com.uevitondev.mspizza.dtos;

import java.io.Serializable;

public class UserCredentialsDTO implements Serializable {
    private String email;
    private String password;

    public UserCredentialsDTO() {
    }

    public UserCredentialsDTO(String email, String password) {
        this.email = email;
        this.password = password;
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
}
