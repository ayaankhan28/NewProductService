package com.ayaankhan.newproductservice.service;

import com.ayaankhan.newproductservice.dtos.FakeStoreProductDto;
import com.ayaankhan.newproductservice.models.Category;
import com.ayaankhan.newproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fsDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        Product product = new Product();
        product.setId(fsDTO.getId());
        product.setTitle(fsDTO.getTitle());
        product.setPrice(fsDTO.getPrice());
        product.setDescription(fsDTO.getDescription());
        Category category = new Category();
        category.setName(fsDTO.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public ArrayList<Product> getAllProducts(){
        RestTemplate restTemp = new RestTemplate();
        FakeStoreProductDto[] fakeStoreAllProductsDtos=restTemp.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);

        return FakeDToProduct(fakeStoreAllProductsDtos);





    }

    private ArrayList<Product> FakeDToProduct(FakeStoreProductDto[] fakeStoreAllProducts){
        ArrayList<Product> ProductList = new ArrayList<>();
        for(int i=0;i<fakeStoreAllProducts.length;i++){
            FakeStoreProductDto  fsDTO = fakeStoreAllProducts[i];
            Product product = new Product();
            product.setId(fsDTO.getId());
            product.setTitle(fsDTO.getTitle());
            product.setPrice(fsDTO.getPrice());
            product.setDescription(fsDTO.getDescription());
            Category category = new Category();
            category.setName(fsDTO.getCategory());
            product.setCategory(category);
            ProductList.add(product);

        }
        return ProductList;


    }
}
