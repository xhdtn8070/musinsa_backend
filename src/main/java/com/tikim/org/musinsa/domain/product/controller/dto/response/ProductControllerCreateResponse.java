package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCreateResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductControllerCreateResponse {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductControllerCreateResponse from(ProductServiceCreateResponse serviceResponse) {
        return ProductControllerCreateResponse.builder()
            .id(serviceResponse.getId())
            .categoryId(serviceResponse.getCategoryId())
            .brandId(serviceResponse.getBrandId())
            .price(serviceResponse.getPrice())
            .build();
    }
}
