package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByCategory;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceMinPriceByCategoryResponse {
    private String categoryName;
    private String brandName;
    private int price;

    public static ProductServiceMinPriceByCategoryResponse from(MinPriceProductByCategory minPriceProductByCategory) {
        return ProductServiceMinPriceByCategoryResponse.builder()
            .categoryName(minPriceProductByCategory.getCategoryName())
            .brandName(minPriceProductByCategory.getBrandName())
            .price(minPriceProductByCategory.getPrice())
            .build();
    }
}
