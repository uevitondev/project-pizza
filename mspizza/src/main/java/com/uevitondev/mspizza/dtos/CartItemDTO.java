package com.uevitondev.mspizza.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class CartItemDTO implements Serializable {
    @NotNull(message = "productId: is mandatory")
    private Long productId;
    @NotNull(message = "qtd: is mandatory")
    @Min(value = 1, message = "qtd: minimum value = 1")
    private Integer qtd;

    public CartItemDTO() {

    }

    public CartItemDTO(Long productId, Integer qtd) {
        this.productId = productId;
        this.qtd = qtd;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
