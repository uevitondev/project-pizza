package com.uevitondev.mspizza.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDTO implements Serializable {
    @NotNull(message = "userId: O id do usuario deve ser informado!")
    private Long userId;
    @NotNull(message = "pizzeriaId: O id da pizzeria deve ser informado!")
    private Long pizzeriaId;
    @NotEmpty(message = "description: A descrição do pedido deve ser informado!")
    @Size(min = 15, max = 255, message = "description: ")
    private String description;
    @NotEmpty(message = "cartItens: Informe os itens de pedido!")
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
