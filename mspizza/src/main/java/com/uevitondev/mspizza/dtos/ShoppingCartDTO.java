package com.uevitondev.mspizza.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO implements Serializable {
    private Long userId;
    private Long pizzeriaId;
    private String description;
    private List<CartItemDTO> cartItens = new ArrayList<>();

    public ShoppingCartDTO() {

    }

    public ShoppingCartDTO(Long userId, Long pizzeriaId, String description, List<CartItemDTO> cartItens) {
        this.userId = userId;
        this.pizzeriaId = pizzeriaId;
        this.description = description;
        this.cartItens = cartItens;
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

    public List<CartItemDTO> getCartItens() {
        return cartItens;
    }

    public void setCartItens(List<CartItemDTO> cartItens) {
        this.cartItens = cartItens;
    }
}
