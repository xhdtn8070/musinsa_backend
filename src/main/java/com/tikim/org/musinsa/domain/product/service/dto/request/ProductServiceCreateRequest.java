package com.tikim.org.musinsa.domain.product.service.dto.request;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerCreateRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceCreateRequest {
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductServiceCreateRequest from(ProductControllerCreateRequest request) {
        return ProductServiceCreateRequest.builder()
            .categoryId(request.getCategoryId())
            .brandId(request.getBrandId())
            .price(request.getPrice())
            .build();
    }
}
