package com.tikim.org.musinsa.domain.category.service.dto.request;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerCreateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryServiceCreateRequest {
    private String name;

    public static CategoryServiceCreateRequest from(CategoryControllerCreateRequest request) {
        CategoryServiceCreateRequest serviceRequest = new CategoryServiceCreateRequest();
        serviceRequest.setName(request.getName());
        return serviceRequest;
    }
}
