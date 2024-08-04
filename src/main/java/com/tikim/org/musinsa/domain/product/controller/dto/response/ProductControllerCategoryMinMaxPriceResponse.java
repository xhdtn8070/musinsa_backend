package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCategoryMinMaxPriceResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductControllerCategoryMinMaxPriceResponse {
    private String categoryName;
    private MinMaxPrice minPrice;
    private MinMaxPrice maxPrice;

    @Getter
    @Builder
    public static class MinMaxPrice {
        private String brandName;
        private int price;
    }

    public static ProductControllerCategoryMinMaxPriceResponse from(ProductServiceCategoryMinMaxPriceResponse serviceResponse) {
        return ProductControllerCategoryMinMaxPriceResponse.builder()
            .categoryName(serviceResponse.getCategoryName())
            .minPrice(MinMaxPrice.builder()
                .brandName(serviceResponse.getMinPrice().getBrandName())
                .price(serviceResponse.getMinPrice().getPrice())
                .build())
            .maxPrice(MinMaxPrice.builder()
                .brandName(serviceResponse.getMaxPrice().getBrandName())
                .price(serviceResponse.getMaxPrice().getPrice())
                .build())
            .build();
    }
}
