package com.example.demopc1.domain;

public class Product {
    private int productId;
    private String productName,productDescr;

    public Product() {
    }

    public Product(int productId, String productName, String productDescr) {
        this.productId = productId;
        this.productName = productName;
        this.productDescr = productDescr;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescr() {
        return productDescr;
    }

    public void setProductDescr(String productDescr) {
        this.productDescr = productDescr;
    }


    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescr='" + productDescr + '\'' +
                '}';
    }
}
