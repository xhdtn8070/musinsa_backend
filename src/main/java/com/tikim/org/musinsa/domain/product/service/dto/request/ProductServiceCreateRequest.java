package com.tikim.org.musinsa.domain.product.service.dto.request;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerCreateRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductServiceCreateRequest {
    private Long categoryId;
    private Long brandId;
    private int price;

    public static ProductServiceCreateRequest from(ProductControllerCreateRequest request) {
        ProductServiceCreateRequest serviceRequest = new ProductServiceCreateRequest();
        serviceRequest.setCategoryId(request.getCategoryId());
        serviceRequest.setBrandId(request.getBrandId());
        serviceRequest.setPrice(request.getPrice());
        return serviceRequest;
    }
}


