package com.example.crud_api.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

import java.util.Objects;

//@Component
@Entity  // It is because Product is the entity class
public class Product {

    @Id
    private int prodId;

    private String prodName;
    private int prodPrice;

    public Product() {

    }
    public Product(int prodId , String prodName, int prodPrice ) {

        this.prodId = prodId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;


    }

    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }

    public boolean equals(Object o)
    {
        if(o == null || this.getClass() != o.getClass())
        {
            return false;
        }

        Product p = (Product) o;
        return prodId == p.prodId;
    }
    public int hashCode() {
        return Objects.hash(prodId); // equals মেথড ওভাররাইড করলে hashCode অবশ্যই করতে হবে
    }
    }
