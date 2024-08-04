package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCategoryMinMaxPriceResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerCategoryMinMaxPriceResponse {
    private String categoryName;
    private MinMaxPrice minPrice;
    private MinMaxPrice maxPrice;

    @Getter
    @Setter
    public static class MinMaxPrice {
        private String brandName;
        private int price;
    }

    public static ProductControllerCategoryMinMaxPriceResponse from(
        ProductServiceCategoryMinMaxPriceResponse serviceResponse) {
        ProductControllerCategoryMinMaxPriceResponse response = new ProductControllerCategoryMinMaxPriceResponse();
        response.setCategoryName(serviceResponse.getCategoryName());

        MinMaxPrice minPrice = new MinMaxPrice();
        minPrice.setBrandName(serviceResponse.getMinPrice().getBrandName());
        minPrice.setPrice(serviceResponse.getMinPrice().getPrice());
        response.setMinPrice(minPrice);

        MinMaxPrice maxPrice = new MinMaxPrice();
        maxPrice.setBrandName(serviceResponse.getMaxPrice().getBrandName());
        maxPrice.setPrice(serviceResponse.getMaxPrice().getPrice());
        response.setMaxPrice(maxPrice);

        return response;
    }
}