package com.ayaankhan.newproductservice.repositories;

import com.ayaankhan.newproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductRepo  extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long aLong);
    Product save(Product product);

}
