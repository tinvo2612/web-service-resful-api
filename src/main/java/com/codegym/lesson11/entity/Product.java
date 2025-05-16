package com.codegym.lesson11.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint
                (columnNames = "link")
})

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String link;
    private Double price;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id" , nullable = false)
    private Category category;

    public Product() {
    }

    public Product(String name, String description, String link, Double price, Integer quantity, Category category) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product(Long id, String name, String description, String link, Double price, Integer quantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
