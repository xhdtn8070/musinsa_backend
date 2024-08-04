package com.tikim.org.musinsa.domain.category.controller.dto.response;

import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceUpdateResponse;
import lombok.Getter;

@Getter
public class CategoryControllerUpdateResponse {
    private Long id;
    private String name;

    public static CategoryControllerUpdateResponse from(CategoryServiceUpdateResponse serviceResponse) {
        CategoryControllerUpdateResponse response = new CategoryControllerUpdateResponse();
        response.id = serviceResponse.getId();
        response.name = serviceResponse.getName();
        return response;
    }
}
