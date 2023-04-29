package com.marketbyshan.dto;

import com.marketbyshan.entities.Product;
import lombok.Data;

@Data
public class ProductDTO extends Product {
    private String name;
    private String description;
    private Long price;
    private String imageUrl;
    private Long categoryId;

}