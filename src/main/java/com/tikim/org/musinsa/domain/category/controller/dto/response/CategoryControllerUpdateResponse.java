package com.tikim.org.musinsa.domain.category.controller.dto.response;

import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceUpdateResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryControllerUpdateResponse {
    private final Long id;
    private final String name;

    public static CategoryControllerUpdateResponse from(CategoryServiceUpdateResponse serviceResponse) {
        return CategoryControllerUpdateResponse.builder()
            .id(serviceResponse.getId())
            .name(serviceResponse.getName())
            .build();
    }
}
