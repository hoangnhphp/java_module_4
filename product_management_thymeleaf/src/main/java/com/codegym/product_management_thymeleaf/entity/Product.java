package com.codegym.product_management_thymeleaf.entity;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private String producer;

    public Product() {}

    public Product(int id, String name, String description, int price, String producer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.producer = producer;
    }

    public Product(String name, String description, int price, String producer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
