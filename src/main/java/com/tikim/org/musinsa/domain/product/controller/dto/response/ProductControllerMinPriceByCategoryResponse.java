package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByCategoryResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductControllerMinPriceByCategoryResponse {
    private String categoryName;
    private String brandName;
    private int price;

    public static ProductControllerMinPriceByCategoryResponse from(ProductServiceMinPriceByCategoryResponse serviceResponse) {
        return ProductControllerMinPriceByCategoryResponse.builder()
            .categoryName(serviceResponse.getCategoryName())
            .brandName(serviceResponse.getBrandName())
            .price(serviceResponse.getPrice())
            .build();
    }
}
