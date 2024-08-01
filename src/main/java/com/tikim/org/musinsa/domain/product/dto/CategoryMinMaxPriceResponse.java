package com.tikim.org.musinsa.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryMinMaxPriceResponse {
    private String categoryName;
    private BrandPrice minPrice;
    private BrandPrice maxPrice;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BrandPrice {
        private String brandName;
        private Integer price;
    }

    public static CategoryMinMaxPriceResponse from(String categoryName, CategoryMinMaxPrice minPrice, CategoryMinMaxPrice maxPrice) {
        return new CategoryMinMaxPriceResponse(
            categoryName,
            new BrandPrice(minPrice.getBrandName(), minPrice.getPrice()),
            new BrandPrice(maxPrice.getBrandName(), maxPrice.getPrice())
        );
    }
}
