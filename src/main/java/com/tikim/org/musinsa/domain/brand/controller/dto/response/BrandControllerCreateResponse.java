package com.tikim.org.musinsa.domain.brand.controller.dto.response;

import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceCreateResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandControllerCreateResponse {
    private final Long id;
    private final String name;

    public static BrandControllerCreateResponse from(BrandServiceCreateResponse serviceResponse) {
        return BrandControllerCreateResponse.builder()
            .id(serviceResponse.getId())
            .name(serviceResponse.getName())
            .build();
    }
}
