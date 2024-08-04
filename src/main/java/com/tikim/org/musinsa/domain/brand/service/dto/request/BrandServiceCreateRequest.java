package com.tikim.org.musinsa.domain.brand.service.dto.request;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerCreateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandServiceCreateRequest {
    private String name;

    public static BrandServiceCreateRequest from(BrandControllerCreateRequest request) {
        BrandServiceCreateRequest serviceRequest = new BrandServiceCreateRequest();
        serviceRequest.setName(request.getName());
        return serviceRequest;
    }
}