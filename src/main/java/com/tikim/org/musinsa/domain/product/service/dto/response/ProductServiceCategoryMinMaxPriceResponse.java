package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.repository.dto.response.CategoryMinMaxPrice;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceCategoryMinMaxPriceResponse {
    private String categoryName;
    private MinMaxPrice minPrice;
    private MinMaxPrice maxPrice;

    @Getter
    @Builder
    public static class MinMaxPrice {
        private String brandName;
        private int price;
    }

    public static ProductServiceCategoryMinMaxPriceResponse from(String categoryName, CategoryMinMaxPrice minPrice, CategoryMinMaxPrice maxPrice) {
        return ProductServiceCategoryMinMaxPriceResponse.builder()
            .categoryName(categoryName)
            .minPrice(MinMaxPrice.builder()
                .brandName(minPrice.getBrandName())
                .price(minPrice.getPrice())
                .build())
            .maxPrice(MinMaxPrice.builder()
                .brandName(maxPrice.getBrandName())
                .price(maxPrice.getPrice())
                .build())
            .build();
    }
}
