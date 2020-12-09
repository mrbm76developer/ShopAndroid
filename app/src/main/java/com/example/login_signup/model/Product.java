package com.example.login_signup.model;

public class Product {
    private int imageId;
    private String productName;

    public Product() {
    }

    public Product(int imageId, String productName) {
        this.imageId = imageId;
        this.productName = productName;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
