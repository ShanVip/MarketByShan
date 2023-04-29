package com.marketbyshan.controllers;


import com.marketbyshan.dto.ProductDTO;
import com.marketbyshan.entities.Product;
import com.marketbyshan.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller/sellerAdProduct")
public class SellerController {
    @Autowired
    private ProductService productService;

    @PostMapping("/{sellerId}/products")
    public ResponseEntity<ProductDTO> createProduct(@PathVariable Long sellerId, @RequestBody ProductDTO productDTO) {
        Product product = productService.createProduct(sellerId, productDTO);
        ProductDTO createdProductDTO = convertToDTO(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductDTO);
    }

    // метод для преобразования Product в ProductDTO
    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }
}