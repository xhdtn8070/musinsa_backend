package com.tikim.org.musinsa.domain.product.service.dto.response;

import com.tikim.org.musinsa.domain.product.repository.dto.response.CategoryMinMaxPrice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceCategoryMinMaxPriceResponse {
    private String categoryName;
    private MinMaxPrice minPrice;
    private MinMaxPrice maxPrice;

    @Getter
    @Setter
    public static class MinMaxPrice {
        private String brandName;
        private int price;
    }

    public static ProductServiceCategoryMinMaxPriceResponse from(String categoryName, CategoryMinMaxPrice minPrice, CategoryMinMaxPrice maxPrice) {
        ProductServiceCategoryMinMaxPriceResponse response = new ProductServiceCategoryMinMaxPriceResponse();
        response.setCategoryName(categoryName);
        MinMaxPrice min = new MinMaxPrice();
        min.setBrandName(minPrice.getBrandName());
        min.setPrice(minPrice.getPrice());
        response.setMinPrice(min);

        MinMaxPrice max = new MinMaxPrice();
        max.setBrandName(maxPrice.getBrandName());
        max.setPrice(maxPrice.getPrice());
        response.setMaxPrice(max);

        return response;
    }
}
