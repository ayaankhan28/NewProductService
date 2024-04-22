package com.ayaankhan.newproductservice.exceptions;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String errormess){
        super(errormess);
    }

}
