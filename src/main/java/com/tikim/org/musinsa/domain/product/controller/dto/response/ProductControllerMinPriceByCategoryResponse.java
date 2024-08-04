package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByCategoryResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerMinPriceByCategoryResponse {
    private String categoryName;
    private int price;

    public static ProductControllerMinPriceByCategoryResponse from(ProductServiceMinPriceByCategoryResponse serviceResponse) {
        ProductControllerMinPriceByCategoryResponse response = new ProductControllerMinPriceByCategoryResponse();
        response.setCategoryName(serviceResponse.getCategoryName());
        response.setPrice(serviceResponse.getPrice());
        return response;
    }
}