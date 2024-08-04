package com.tikim.org.musinsa.domain.brand.service.dto.request;

import com.tikim.org.musinsa.domain.brand.controller.dto.request.BrandControllerCreateRequest;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandServiceCreateRequest {
    private String name;

    public static BrandServiceCreateRequest from(BrandControllerCreateRequest request) {
        return BrandServiceCreateRequest.builder()
            .name(request.getName())
            .build();
    }
}
