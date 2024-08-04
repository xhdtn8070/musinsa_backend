package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceReadResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductControllerReadResponse {
    private Long id;
    private String categoryName;
    private Long categoryId;
    private String brandName;
    private Long brandId;
    private int price;

    public static ProductControllerReadResponse from(ProductServiceReadResponse serviceResponse) {
        return ProductControllerReadResponse.builder()
            .id(serviceResponse.getId())
            .categoryName(serviceResponse.getCategoryName())
            .categoryId(serviceResponse.getCategoryId())
            .brandName(serviceResponse.getBrandName())
            .brandId(serviceResponse.getBrandId())
            .price(serviceResponse.getPrice())
            .build();
    }
}
