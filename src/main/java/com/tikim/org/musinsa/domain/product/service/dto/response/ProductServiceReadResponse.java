package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceReadResponse {
    private Long id;
    private String categoryName;
    private Long categoryId;
    private String brandName;
    private Long brandId;
    private int price;

    public static ProductServiceReadResponse from(Product product) {
        return ProductServiceReadResponse.builder()
            .id(product.getId())
            .categoryName(product.getCategory().getName())
            .categoryId(product.getCategoryId())
            .brandName(product.getBrand().getName())
            .brandId(product.getBrandId())
            .price(product.getPrice())
            .build();
    }
}
