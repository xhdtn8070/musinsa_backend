package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceReadResponse {
    private Long id;
    private String categoryName;
    private String brandName;
    private int price;

    public static ProductServiceReadResponse from(Product product) {
        ProductServiceReadResponse response = new ProductServiceReadResponse();
        response.setId(product.getId());
        response.setCategoryName(product.getCategory().getName());
        response.setBrandName(product.getBrand().getName());
        response.setPrice(product.getPrice());
        return response;
    }
}