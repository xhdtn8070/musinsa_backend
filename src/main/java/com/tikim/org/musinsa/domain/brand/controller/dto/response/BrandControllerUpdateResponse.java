package com.tikim.org.musinsa.domain.brand.controller.dto.response;

import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceUpdateResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandControllerUpdateResponse {
    private Long id;
    private String name;

    public static BrandControllerUpdateResponse from(BrandServiceUpdateResponse serviceResponse) {
        BrandControllerUpdateResponse response = new BrandControllerUpdateResponse();
        response.setId(serviceResponse.getId());
        response.setName(serviceResponse.getName());
        return response;
    }
}