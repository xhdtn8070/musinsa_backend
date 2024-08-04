package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceMinPriceByCategoryResponse {
    private String categoryName;
    private int price;

    public static ProductServiceMinPriceByCategoryResponse from(MinPriceProductByCategory minPriceProductByCategory) {
        ProductServiceMinPriceByCategoryResponse response = new ProductServiceMinPriceByCategoryResponse();
        response.setCategoryName(minPriceProductByCategory.getCategoryName());
        response.setPrice(minPriceProductByCategory.getPrice());
        return response;
    }
}
