package com.tikim.org.musinsa.domain.brand.service.dto.response;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BrandServiceUpdateResponse {
    private final Long id;
    private final String name;

    public static BrandServiceUpdateResponse from(Brand brand) {
        return BrandServiceUpdateResponse.builder()
            .id(brand.getId())
            .name(brand.getName())
            .build();
    }
}
