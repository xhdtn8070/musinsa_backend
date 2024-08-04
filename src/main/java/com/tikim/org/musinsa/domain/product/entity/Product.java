package com.tikim.org.musinsa.domain.product.entity;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceCreateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceUpdateRequest;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private int price;

    public static Product from(ProductServiceCreateRequest request, Category category, Brand brand) {
        Product product = new Product();
        product.setCategory(category);
        product.setBrand(brand);
        product.setPrice(request.getPrice());
        return product;
    }

    public void update(ProductServiceUpdateRequest request, Category category, Brand brand) {
        this.setCategory(category);
        this.setBrand(brand);
        this.setPrice(request.getPrice());
    }
}
