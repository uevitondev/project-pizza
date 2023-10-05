package com.uevitondev.mspizza.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ShoppingCartDTO implements Serializable {
    @NotNull(message = "userId: is mandatory")
    private Long userId;
    @NotNull(message = "pizzeriaId: is mandatory")
    private Long pizzeriaId;
    @NotBlank(message = "description: is mandatory")
    private String description;
    @NotEmpty(message = "cartItems: cannot be empty")
    private final Set<@Valid CartItemDTO> cartItems = new HashSet<>();

    public ShoppingCartDTO() {

    }

    public ShoppingCartDTO(Long userId, Long pizzeriaId, String description) {
        this.userId = userId;
        this.pizzeriaId = pizzeriaId;
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPizzeriaId() {
        return pizzeriaId;
    }

    public void setPizzeriaId(Long pizzeriaId) {
        this.pizzeriaId = pizzeriaId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CartItemDTO> getCartItems() {
        return cartItems;
    }
}
