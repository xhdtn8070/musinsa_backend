package com.tikim.org.musinsa.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryMinMaxPriceResponse {
    private String categoryName;
    private List<BrandPrice> minPrices;
    private List<BrandPrice> maxPrices;

    @Data
    @AllArgsConstructor
    public static class BrandPrice {
        private String brandName;
        private Integer price;
    }
}
