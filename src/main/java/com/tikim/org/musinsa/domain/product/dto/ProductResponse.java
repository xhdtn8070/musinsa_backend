package com.tikim.org.musinsa.domain.product.dto;

import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String categoryName;
    private String brandName;
    private int price;

    public static ProductResponse from(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setCategoryName(product.getCategory().getName());
        response.setBrandName(product.getBrand().getName());
        response.setPrice(product.getPrice());
        return response;
    }
}
