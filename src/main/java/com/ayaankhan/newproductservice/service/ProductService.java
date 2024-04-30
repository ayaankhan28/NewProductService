package com.ayaankhan.newproductservice.service;

import com.ayaankhan.newproductservice.models.Product;

import java.util.ArrayList;

public interface ProductService{
    Product getProductById(Long id);
    ArrayList<Product> getAllProducts();
    Product createProduct(Product product);
}
