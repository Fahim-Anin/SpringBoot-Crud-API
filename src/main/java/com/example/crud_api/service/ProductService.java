package com.example.crud_api.service;

import com.example.crud_api.model.Product;
import com.example.crud_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepo;
    //Spring JPA creates the class of Interface ProductRepository and Spring creates the object of this class to use



//    List<Product> productList = new ArrayList<>(Arrays.asList(new Product(101, "Camera",
//                    20000),
//            new Product(102,"iPhone", 2000)));


//    GET METHOD WORKS HERE: Send data from controller to client
    public List<Product> getProducts() {
//          without JPA->
//        System.out.println(productList);
//        return productList;

//         With JPA ->
          return productRepo.findAll();  // this will return the full product list from DB
    }

   /* Get Method: See product list by id*/
    public Product getProductById(int productId) {

//        without JPA ->
//        for(Product prod: productList)
//        {
//            if(prod.getProdId() == productId)
//            {
//                 return prod;
//            }
//        }
//
//        throw new RuntimeException("Product with ID " + productId + " not found.");

//        With JPA ->
        return productRepo.findById(productId).orElse(new Product());
    }

//    post method
    public void addProduct(Product product) {
//        WithOUT JPA ->
//        productList.add(product);

//        With JPA ->
        productRepo.save(product);

    }

//    Update Method
    public void updateProduct(Product product) {
//        Without Jpa ->
//        productList.set(productList.indexOf(product), product);

//          With JPA ->
        productRepo.save(product);

    }

    public void deleteProduct(int  productId) {
//        Without JPA ->
//        int index =0;
//        for(int i =0;i<productList.size();i++)
//        {
//            if(productList.get(i).getProdId() == productId)
//            {
//                index=i;
//                break;
//            }
//        }
//        productList.remove(index);

//        With JPA ->
        productRepo.deleteById(productId);

    }


}
