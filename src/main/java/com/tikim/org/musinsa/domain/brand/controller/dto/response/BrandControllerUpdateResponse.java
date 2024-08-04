package com.tikim.org.musinsa.domain.brand.controller.dto.response;

import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceUpdateResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandControllerUpdateResponse {
    private final Long id;
    private final String name;

    public static BrandControllerUpdateResponse from(BrandServiceUpdateResponse serviceResponse) {
        return BrandControllerUpdateResponse.builder()
            .id(serviceResponse.getId())
            .name(serviceResponse.getName())
            .build();
    }
}
