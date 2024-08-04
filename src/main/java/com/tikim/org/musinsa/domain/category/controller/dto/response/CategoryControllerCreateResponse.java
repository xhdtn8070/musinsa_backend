package com.tikim.org.musinsa.domain.category.controller.dto.response;

import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceCreateResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryControllerCreateResponse {
    private final Long id;
    private final String name;

    public static CategoryControllerCreateResponse from(CategoryServiceCreateResponse serviceResponse) {
        return CategoryControllerCreateResponse.builder()
            .id(serviceResponse.getId())
            .name(serviceResponse.getName())
            .build();
    }
}
