package com.example.casestudy.models;

import java.math.BigDecimal;

public class Orders {
    public int id;
    public String name;
    public BigDecimal price;
    public String image;
    public String description;
    public String orderStatus;
    public int categoryId;
    String categories_name;

    public Orders(String name, BigDecimal price, String image, String description, String orderStatus) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.orderStatus = orderStatus;
    }

    public Orders(int id, String name, BigDecimal price, String image, String description, String orderStatus, String categories_name) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.orderStatus = orderStatus;
        this.categories_name = categories_name;
    }

    public Orders(int id, String name, BigDecimal price, String image, String description, String orderStatus) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.orderStatus = orderStatus;
    }

    public Orders(int id, String name, BigDecimal price, String image, String description, String orderStatus, int categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.orderStatus = orderStatus;
        this.categoryId = categoryId;
    }

    public Orders(String name, BigDecimal price, String image, String description, String categories_name, String orderStatus) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
        this.orderStatus = orderStatus;
        this.categories_name = categories_name;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategories_name() {
        return categories_name;
    }

    public void setCategories_name(String categories_name) {
        this.categories_name = categories_name;
    }
}
