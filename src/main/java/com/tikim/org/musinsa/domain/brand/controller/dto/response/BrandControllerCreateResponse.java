package com.tikim.org.musinsa.domain.brand.controller.dto.response;


import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceCreateResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandControllerCreateResponse {
    private Long id;
    private String name;

    public static BrandControllerCreateResponse from(BrandServiceCreateResponse serviceResponse) {
        BrandControllerCreateResponse response = new BrandControllerCreateResponse();
        response.setId(serviceResponse.getId());
        response.setName(serviceResponse.getName());
        return response;
    }
}