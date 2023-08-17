package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.OrderItem;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {
    private Long id;
    private Integer qtd;
    private Double subtotal;
    private ProductDTO product;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long id, Integer qtd, Double subtotal, ProductDTO product) {
        this.id = id;
        this.qtd = qtd;
        this.subtotal = subtotal;
        this.product = product;
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.qtd = orderItem.getQtd();
        this.subtotal = orderItem.getSubtotal();
        this.product = new ProductDTO(orderItem.getProduct());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
