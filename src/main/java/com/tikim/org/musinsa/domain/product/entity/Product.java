package com.tikim.org.musinsa.domain.product.entity;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceCreateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceUpdateRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "category_id", insertable = false, updatable = false)
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "brand_id", insertable = false, updatable = false)
    private Long brandId;

    private int price;

    public static Product from(ProductServiceCreateRequest request, Category category, Brand brand) {
        return Product.builder()
            .category(category)
            .brand(brand)
            .price(request.getPrice())
            .build();
    }

    public void update(ProductServiceUpdateRequest request, Category category, Brand brand) {
        this.category = category;
        this.brand = brand;
        this.price = request.getPrice();
    }
}
