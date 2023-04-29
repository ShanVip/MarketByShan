package com.marketbyshan.repositories;


import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository<Category, Long> {
    Category findById(Long id);
}
