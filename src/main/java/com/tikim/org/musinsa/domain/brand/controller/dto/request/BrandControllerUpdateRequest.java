package com.tikim.org.musinsa.domain.brand.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BrandControllerUpdateRequest {
    private String name;

    @Builder
    public BrandControllerUpdateRequest(String name) {
        this.name = name;
    }
}
