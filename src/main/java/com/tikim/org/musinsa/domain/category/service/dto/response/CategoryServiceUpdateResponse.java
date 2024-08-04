package com.tikim.org.musinsa.domain.category.service.dto.response;

import com.tikim.org.musinsa.domain.category.entity.Category;
import lombok.Getter;

@Getter
public class CategoryServiceUpdateResponse {
    private Long id;
    private String name;

    public static CategoryServiceUpdateResponse from(Category category) {
        CategoryServiceUpdateResponse dto = new CategoryServiceUpdateResponse();
        dto.id = category.getId();
        dto.name = category.getName();
        return dto;
    }
}
