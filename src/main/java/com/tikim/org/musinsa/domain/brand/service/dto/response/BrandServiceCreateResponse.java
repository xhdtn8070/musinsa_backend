package com.tikim.org.musinsa.domain.brand.service.dto.response;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import lombok.Getter;

@Getter
public class BrandServiceCreateResponse {
    private Long id;
    private String name;

    public static BrandServiceCreateResponse from(Brand brand) {
        BrandServiceCreateResponse response = new BrandServiceCreateResponse();
        response.id = brand.getId();
        response.name = brand.getName();
        return response;
    }
}