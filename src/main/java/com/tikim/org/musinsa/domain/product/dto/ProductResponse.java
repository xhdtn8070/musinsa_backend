package com.tikim.org.musinsa.domain.product.dto;

import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String categoryName;
    private String brandName;
    private int price;

    public static ProductResponse from(Product product) {
        ProductResponse response = new ProductResponse();
        response.id = product.getId();
        response.categoryName = product.getCategory().getName();
        response.brandName = product.getBrand().getName();
        response.price = product.getPrice();
        return response;
    }
}
