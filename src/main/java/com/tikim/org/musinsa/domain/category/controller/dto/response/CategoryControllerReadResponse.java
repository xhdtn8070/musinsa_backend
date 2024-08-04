package com.tikim.org.musinsa.domain.category.controller.dto.response;

import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;
import lombok.Getter;

@Getter
public class CategoryControllerReadResponse {
    private Long id;
    private String name;

    public static CategoryControllerReadResponse from(CategoryServiceReadResponse serviceResponse) {
        CategoryControllerReadResponse response = new CategoryControllerReadResponse();
        response.id = serviceResponse.getId();
        response.name = serviceResponse.getName();
        return response;
    }
}
