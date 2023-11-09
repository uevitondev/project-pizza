package com.uevitondev.mspizza.dtos;

import jakarta.validation.Valid;
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
    @NotEmpty(message = "cartItems: cannot be empty")
    private final Set<@Valid CartItemDTO> cartItems = new HashSet<>();

    public ShoppingCartDTO() {

    }

    public ShoppingCartDTO(Long userId, Long pizzeriaId) {
        this.userId = userId;
        this.pizzeriaId = pizzeriaId;
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

    public Set<CartItemDTO> getCartItems() {
        return cartItems;
    }
}
