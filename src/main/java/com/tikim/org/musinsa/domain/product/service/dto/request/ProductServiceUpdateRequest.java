package com.tikim.org.musinsa.domain.product.service.dto.request;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerUpdateRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceUpdateRequest {
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductServiceUpdateRequest from(ProductControllerUpdateRequest request) {
        return ProductServiceUpdateRequest.builder()
            .categoryId(request.getCategoryId())
            .brandId(request.getBrandId())
            .price(request.getPrice())
            .build();
    }
}
