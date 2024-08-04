package com.tikim.org.musinsa.domain.brand.dto;

import com.tikim.org.musinsa.domain.brand.entity.Brand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandResponse {
    private Long id;
    private String name;

    public static BrandResponse from(Brand brand) {
        BrandResponse response = new BrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
    }
}