package com.tikim.org.musinsa.domain.brand.service.dto.request;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerUpdateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandServiceUpdateRequest {
    private String name;

    public static BrandServiceUpdateRequest from(BrandControllerUpdateRequest request) {
        BrandServiceUpdateRequest serviceRequest = new BrandServiceUpdateRequest();
        serviceRequest.setName(request.getName());
        return serviceRequest;
    }
}