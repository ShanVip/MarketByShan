package com.marketbyshan.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Long price;

    private String image;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER) // загрузка категорий вместе с товаром
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User seller;

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getSeller() {
        return seller;
    }
}
