package com.uevitondev.mspizza.tests;

import com.uevitondev.mspizza.entities.Category;
import com.uevitondev.mspizza.entities.Pizzeria;
import com.uevitondev.mspizza.entities.Product;

public class Factory {
    public static Product createProduct() {
        Product product = new Product(1L, "Pizza de Calabresa", "Pizza saborosa, com calabresa de ótima qualidade", 45.0);
        product.setCategory(new Category(1L, "PIZZA"));
        product.setPizzeria(new Pizzeria(1L, "Pizzaria do Zé"));
        return product;
    }
}
