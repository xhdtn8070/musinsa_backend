package com.tikim.org.musinsa.domain.category.service.dto.request;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerUpdateRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryServiceUpdateRequest {
    private final String name;

    public static CategoryServiceUpdateRequest from(CategoryControllerUpdateRequest request) {
        return CategoryServiceUpdateRequest.builder()
            .name(request.getName())
            .build();
    }
}
