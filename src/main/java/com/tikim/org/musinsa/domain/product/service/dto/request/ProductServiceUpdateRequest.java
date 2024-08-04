package com.tikim.org.musinsa.domain.product.service.dto.request;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerUpdateRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceUpdateRequest {
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductServiceUpdateRequest from(ProductControllerUpdateRequest request) {
        ProductServiceUpdateRequest serviceRequest = new ProductServiceUpdateRequest();
        serviceRequest.setCategoryId(request.getCategoryId());
        serviceRequest.setBrandId(request.getBrandId());
        serviceRequest.setPrice(request.getPrice());
        return serviceRequest;
    }
}