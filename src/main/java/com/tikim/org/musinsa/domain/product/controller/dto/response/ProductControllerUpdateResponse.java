package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceUpdateResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductControllerUpdateResponse {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductControllerUpdateResponse from(ProductServiceUpdateResponse serviceResponse) {
        return ProductControllerUpdateResponse.builder()
            .id(serviceResponse.getId())
            .categoryId(serviceResponse.getCategoryId())
            .brandId(serviceResponse.getBrandId())
            .price(serviceResponse.getPrice())
            .build();
    }
}
