package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Pizzeria;
import com.uevitondev.mspizza.entities.Product;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PizzeriaDTO implements Serializable {
    private Long id;
    @NotBlank(message = "name: is mandatory")
    private String name;
    private final Set<ProductDTO> products = new HashSet<>();

    public PizzeriaDTO() {
    }

    public PizzeriaDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public PizzeriaDTO(Pizzeria pizzeria) {
        this.id = pizzeria.getId();
        this.name = pizzeria.getName();
    }

    public PizzeriaDTO(Pizzeria pizzeria, List<Product> products) {
        this.id = pizzeria.getId();
        this.name = pizzeria.getName();
        products.forEach(product -> this.products.add(new ProductDTO(product)));
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

    public Set<ProductDTO> getProducts() {
        return products;
    }
}
