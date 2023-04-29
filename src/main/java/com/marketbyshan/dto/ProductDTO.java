package com.marketbyshan.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private Long price;
    private String imageUrl;
    private Long categoryId;

}