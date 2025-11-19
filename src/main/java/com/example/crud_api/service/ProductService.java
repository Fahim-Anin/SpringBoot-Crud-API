package com.example.crud_api.service;

import com.example.crud_api.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> productList = new ArrayList<>(Arrays.asList(new Product(101, "Camera",
                    20000),
            new Product(102,"iPhone", 2000)));

//    GET METHOD WORKS HERE: Send data from controller to client
    public List<Product> getProducts() {
        System.out.println(productList);
        return productList;
    }

   /* Get Method: See product list by id*/
    public Product getProductById(int productId) {

        for(Product prod: productList)
        {
            if(prod.getProdId() == productId)
            {
                 return prod;
            }
        }

        throw new RuntimeException("Product with ID " + productId + " not found.");
    }

//    post method
    public void addProduct(Product product) {
        productList.add(product);
    }

//    Update Method
    public void updateProduct(Product product) {
        productList.set(productList.indexOf(product), product);

    }

    public void deleteProduct(int  productId) {
        int index =0;
        for(int i =0;i<productList.size();i++)
        {
            if(productList.get(i).getProdId() == productId)
            {
                index=i;
                break;
            }
        }
        productList.remove(index);

    }


}
