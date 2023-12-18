package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Role;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class RoleDTO implements Serializable {
    private Long id;
    @NotBlank(message = "authority: is mandatory")
    private String authority;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.authority = role.getAuthority();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}