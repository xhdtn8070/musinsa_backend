package com.tikim.org.musinsa.domain.category.controller.dto.response;

import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryControllerReadResponse {
    private final Long id;
    private final String name;

    public static CategoryControllerReadResponse from(CategoryServiceReadResponse serviceResponse) {
        return CategoryControllerReadResponse.builder()
            .id(serviceResponse.getId())
            .name(serviceResponse.getName())
            .build();
    }
}
