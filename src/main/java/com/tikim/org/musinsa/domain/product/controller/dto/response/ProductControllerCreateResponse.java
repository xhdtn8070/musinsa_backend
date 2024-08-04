package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCreateResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerCreateResponse {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductControllerCreateResponse from(ProductServiceCreateResponse serviceResponse) {
        ProductControllerCreateResponse response = new ProductControllerCreateResponse();
        response.setId(serviceResponse.getId());
        response.setCategoryId(serviceResponse.getCategoryId());
        response.setBrandId(serviceResponse.getBrandId());
        response.setPrice(serviceResponse.getPrice());
        return response;
    }
}
