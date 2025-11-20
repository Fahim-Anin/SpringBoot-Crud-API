package com.example.crud_api.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Product {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String prodName;
    private int prodPrice;

    public Product() {
        // Required for JPA
    }

    // Constructor for convenience (optional, but good practice)
    public Product(int prodId , String prodName, int prodPrice ) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    // --- GETTERS ---
    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    // --- SETTERS (CRITICAL FIX) ---
    // You do not need a setter for prodId if it's auto-generated,
    // but you need one to set the object's state if you pass an ID for an update.
    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodId == product.prodId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId);
    }
}