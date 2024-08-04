package com.tikim.org.musinsa.domain.category.dto;

import com.tikim.org.musinsa.domain.category.entity.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;

    public static CategoryResponse from(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }
}