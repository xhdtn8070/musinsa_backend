package com.tikim.org.musinsa.domain.brand.controller.dto.response;

import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandControllerReadResponse {
    private Long id;
    private String name;

    public static BrandControllerReadResponse from(BrandServiceReadResponse serviceResponse) {
        BrandControllerReadResponse response = new BrandControllerReadResponse();
        response.setId(serviceResponse.getId());
        response.setName(serviceResponse.getName());
        return response;
    }
}
