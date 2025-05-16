package com.codegym.lesson11.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


public class ProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String link;
    private Double price;
    private Integer quantity;
    private Long categoryId;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, String link, Double price, Integer quantity, Long categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public ProductDto(String name, String description, String link, Double price, Integer quantity, Long categoryId) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
