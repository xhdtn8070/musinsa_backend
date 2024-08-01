package com.tikim.org.musinsa.domain.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.category.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Brand brand;

    @ManyToOne
    private Category category;

    private int price;
}
