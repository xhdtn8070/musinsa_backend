package com.tikim.org.musinsa.domain.product.controller.dto.response;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceUpdateResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerUpdateResponse {
    private Long id;
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductControllerUpdateResponse from(ProductServiceUpdateResponse serviceResponse) {
        ProductControllerUpdateResponse response = new ProductControllerUpdateResponse();
        response.setId(serviceResponse.getId());
        response.setCategoryId(serviceResponse.getCategoryId());
        response.setBrandId(serviceResponse.getBrandId());
        response.setPrice(serviceResponse.getPrice());
        return response;
    }
}
