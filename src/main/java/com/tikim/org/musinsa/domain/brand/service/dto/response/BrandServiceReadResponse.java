package com.tikim.org.musinsa.domain.brand.service.dto.response;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import lombok.Getter;

@Getter
public class BrandServiceReadResponse {
    private Long id;
    private String name;

    public static BrandServiceReadResponse from(Brand brand) {
        BrandServiceReadResponse response = new BrandServiceReadResponse();
        response.id = brand.getId();
        response.name = brand.getName();
        return response;
    }
}