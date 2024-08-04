package com.tikim.org.musinsa.domain.category.service.dto.response;

import com.tikim.org.musinsa.domain.category.entity.Category;
import lombok.Getter;

@Getter
public class CategoryServiceCreateResponse {
    private Long id;
    private String name;

    public static CategoryServiceCreateResponse from(Category category) {
        CategoryServiceCreateResponse dto = new CategoryServiceCreateResponse();
        dto.id = category.getId();
        dto.name = category.getName();
        return dto;
    }
}
