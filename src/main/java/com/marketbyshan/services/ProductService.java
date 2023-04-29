package com.marketbyshan.services;

import com.marketbyshan.dto.ProductDTO;
import com.marketbyshan.entities.Category;
import com.marketbyshan.entities.Product;
import com.marketbyshan.entities.User;
import com.marketbyshan.repositories.CategoryRepository;
import com.marketbyshan.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public Product createProduct(ProductDTO productDTO, User user)  // DTO это прослойка между, например, контролером и сервисом
     {

         Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImageUrl(productDTO.getImageUrl());
        product.setSeller(user);
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
    }
}