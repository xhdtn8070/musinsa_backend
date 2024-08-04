package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceReadResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerReadResponse {
    private Long id;
    private String categoryName;
    private String brandName;
    private int price;

    public static ProductControllerReadResponse from(ProductServiceReadResponse serviceResponse) {
        ProductControllerReadResponse response = new ProductControllerReadResponse();
        response.setId(serviceResponse.getId());
        response.setCategoryName(serviceResponse.getCategoryName());
        response.setBrandName(serviceResponse.getBrandName());
        response.setPrice(serviceResponse.getPrice());
        return response;
    }
}
