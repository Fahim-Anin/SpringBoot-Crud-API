package com.example.crud_api.controller;

import com.example.crud_api.model.Product;
import com.example.crud_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Accept the response from dispatcher and take the data from service  and send the response as view
@RestController
 class ProductController {

    @Autowired
    private ProductService service;

//    GET Method: fetch the full product list
    @GetMapping("/products")
    public List<Product> getProducts() {
        System.out.println("From Service: " + service.getProducts());
        return service.getProducts();
    }

//    Get Method: fetch the produc by id
    @RequestMapping("/products/{productId}")
    public Product getProductsById(@PathVariable int productId) {
        return service.getProductById(productId);
    }

    @PostMapping("/products")
    public  void addProduct(@RequestBody Product product) {
//        @RequestBody is for Deserialization which tells JackSon library to convert the JSON file to object after Post the data. Other wise the new data cannot be seen
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void UpdateProduct(@RequestBody Product product) {
        System.out.println(product);
        service.updateProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public void DeleteProduct(@PathVariable int productId)
    {
        service.deleteProduct(productId);
    }
}
