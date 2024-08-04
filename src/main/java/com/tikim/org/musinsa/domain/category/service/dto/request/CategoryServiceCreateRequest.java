package com.tikim.org.musinsa.domain.category.service.dto.request;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerCreateRequest;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryServiceCreateRequest {
    private final String name;

    public static CategoryServiceCreateRequest from(CategoryControllerCreateRequest request) {
        return CategoryServiceCreateRequest.builder()
            .name(request.getName())
            .build();
    }
}
