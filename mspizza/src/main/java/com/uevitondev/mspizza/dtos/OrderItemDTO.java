package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.OrderItem;

import java.io.Serializable;

public class OrderItemDTO implements Serializable {
    private Long id;
    private Integer quantity;
    private Double subtotal;
    private String observation;
    private ProductDTO product;

    public OrderItemDTO() {

    }

    public OrderItemDTO(Long id, Integer quantity, Double subtotal, String observation, ProductDTO product) {
        this.id = id;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.observation = observation;
        this.product = product;
    }

    public OrderItemDTO(OrderItem orderItem) {
        this.id = orderItem.getId();
        this.quantity = orderItem.getQuantity();
        this.subtotal = orderItem.getSubtotal();
        this.observation = orderItem.getObservation();
        this.product = new ProductDTO(orderItem.getProduct());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
