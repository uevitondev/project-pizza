package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.Pizzeria;
import com.uevitondev.mspizza.entities.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PizzeriaDTO implements Serializable {
    private Long id;
    private String name;
    private List<ProductDTO> products = new ArrayList<>();

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
        this.products = products.stream().map(ProductDTO::new).toList();
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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
