package com.ayaankhan.newproductservice.service;

import com.ayaankhan.newproductservice.exceptions.ProductNotFound;
import com.ayaankhan.newproductservice.models.Product;
import com.ayaankhan.newproductservice.repositories.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
@Primary
public class SelfProductService implements ProductService{

    private ProductRepo productRepo;

    public SelfProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalproduct= productRepo.findById(id);
        if(optionalproduct.isEmpty()){
            throw new ProductNotFound("Product not found");
        }
        else{
            return optionalproduct.get();

        }

    }
    @Override
    public ArrayList<Product> getAllProducts(){
        return null;
    }
    public Product createProduct(Product product){
        return productRepo.save(product);
    }


}
