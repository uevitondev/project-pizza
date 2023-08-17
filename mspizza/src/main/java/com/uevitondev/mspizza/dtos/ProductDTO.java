package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Product;

import java.io.Serializable;

public class ProductDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long pizzeriaId;

    public ProductDTO() {

    }

    public ProductDTO(Long id, String name, String description, Double price, Long pizzeriaId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.pizzeriaId = pizzeriaId;
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.pizzeriaId = product.getPizzeria().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getPizzeriaId() {
        return pizzeriaId;
    }

    public void setPizzeriaId(Long pizzeriaId) {
        this.pizzeriaId = pizzeriaId;
    }
}
