package com.tikim.org.musinsa.domain.category.controller.dto.response;

import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceCreateResponse;
import lombok.Getter;

@Getter
public class CategoryControllerCreateResponse {
    private Long id;
    private String name;

    public static CategoryControllerCreateResponse from(CategoryServiceCreateResponse serviceResponse) {
        CategoryControllerCreateResponse response = new CategoryControllerCreateResponse();
        response.id = serviceResponse.getId();
        response.name = serviceResponse.getName();
        return response;
    }
}
