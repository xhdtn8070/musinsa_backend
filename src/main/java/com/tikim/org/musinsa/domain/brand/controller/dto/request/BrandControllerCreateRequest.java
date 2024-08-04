package com.tikim.org.musinsa.domain.brand.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandControllerCreateRequest {
    private String name;

    @Builder
    public BrandControllerCreateRequest(String name) {
        this.name = name;
    }
}