package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceUpdateResponse {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductServiceUpdateResponse from(Product product) {
        return ProductServiceUpdateResponse.builder()
            .id(product.getId())
            .categoryId(product.getCategory().getId())
            .brandId(product.getBrand().getId())
            .price(product.getPrice())
            .build();
    }
}
