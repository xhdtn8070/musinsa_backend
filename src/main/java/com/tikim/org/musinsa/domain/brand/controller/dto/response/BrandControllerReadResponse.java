package com.tikim.org.musinsa.domain.brand.controller.dto.response;

import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandControllerReadResponse {
    private final Long id;
    private final String name;

    public static BrandControllerReadResponse from(BrandServiceReadResponse serviceResponse) {
        return BrandControllerReadResponse.builder()
            .id(serviceResponse.getId())
            .name(serviceResponse.getName())
            .build();
    }
}

