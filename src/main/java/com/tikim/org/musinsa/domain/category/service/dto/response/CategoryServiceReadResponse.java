package com.tikim.org.musinsa.domain.category.service.dto.response;

import com.tikim.org.musinsa.domain.category.entity.Category;
import lombok.Getter;

@Getter
public class CategoryServiceReadResponse {
    private Long id;
    private String name;

    public static CategoryServiceReadResponse from(Category category) {
        CategoryServiceReadResponse dto = new CategoryServiceReadResponse();
        dto.id = category.getId();
        dto.name = category.getName();
        return dto;
    }
}
