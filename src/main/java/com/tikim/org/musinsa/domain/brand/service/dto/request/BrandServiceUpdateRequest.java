package com.tikim.org.musinsa.domain.brand.service.dto.request;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerUpdateRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandServiceUpdateRequest {
    private final String name;

    public static BrandServiceUpdateRequest from(BrandControllerUpdateRequest request) {
        return BrandServiceUpdateRequest.builder()
            .name(request.getName())
            .build();
    }
}
