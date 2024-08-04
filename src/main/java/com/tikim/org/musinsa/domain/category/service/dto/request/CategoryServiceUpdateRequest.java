package com.tikim.org.musinsa.domain.category.service.dto.request;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerUpdateRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryServiceUpdateRequest {
    private String name;

    public static CategoryServiceUpdateRequest from(CategoryControllerUpdateRequest request) {
        CategoryServiceUpdateRequest serviceRequest = new CategoryServiceUpdateRequest();
        serviceRequest.setName(request.getName());
        return serviceRequest;
    }
}
