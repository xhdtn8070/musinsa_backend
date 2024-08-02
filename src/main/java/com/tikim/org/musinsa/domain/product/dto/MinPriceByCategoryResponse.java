package com.tikim.org.musinsa.domain.product.dto;

public record MinPriceByCategoryResponse(String categoryName, String brandName, int price) {

    public static MinPriceByCategoryResponse from(MinPriceProductByCategory p) {
        return new MinPriceByCategoryResponse(p.getCategoryName(), p.getBrandName(), p.getPrice());
    }
}

