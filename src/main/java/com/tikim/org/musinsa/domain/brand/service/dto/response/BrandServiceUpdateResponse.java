package com.tikim.org.musinsa.domain.brand.service.dto.response;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import lombok.Getter;

@Getter
public class BrandServiceUpdateResponse {
    private Long id;
    private String name;

    public static BrandServiceUpdateResponse from(Brand brand) {
        BrandServiceUpdateResponse response = new BrandServiceUpdateResponse();
        response.id = brand.getId();
        response.name = brand.getName();
        return response;
    }
}