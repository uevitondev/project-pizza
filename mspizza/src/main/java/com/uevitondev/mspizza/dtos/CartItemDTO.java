package com.uevitondev.mspizza.dtos;

import java.io.Serializable;

public class CartItemDTO implements Serializable {
    private Long productId;
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
