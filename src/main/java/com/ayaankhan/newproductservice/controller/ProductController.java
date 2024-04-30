package com.ayaankhan.newproductservice.controller;


// Controllers are the entry point of the application.
// They are responsible for handling incoming HTTP requests and sending the response back to the client.
// The @RestController annotation is used to define a controller in Spring Boot.
// The rest controller passes the request to the service layer and returns the response back to the client.

import com.ayaankhan.newproductservice.dtos.ExceptionDto;
import com.ayaankhan.newproductservice.models.Product;
import com.ayaankhan.newproductservice.service.FakeStoreProductService;
import com.ayaankhan.newproductservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);

    }

    // Function to Get All Products
    @GetMapping
    public ArrayList<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
}
