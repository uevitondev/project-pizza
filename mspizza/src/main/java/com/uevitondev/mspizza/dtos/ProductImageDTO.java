package com.uevitondev.mspizza.dtos;

import com.uevitondev.mspizza.entities.ProductImage;

public class ProductImageDTO {
    private Long id;
    private String url;
    private String type;

    public ProductImageDTO() {
    }

    public ProductImageDTO(Long id, String url, String type) {
        this.id = id;
        this.url = url;
        this.type = type;
    }

    public ProductImageDTO(ProductImage productImage) {
        this.id = productImage.getId();
        this.url = productImage.getUrl();
        this.type = productImage.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}