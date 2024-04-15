package com.ayaankhan.newproductservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;
    private String title;
    private Double price;
    private String description;
    private Category category;

}
