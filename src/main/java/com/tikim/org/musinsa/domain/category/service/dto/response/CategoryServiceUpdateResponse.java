package com.tikim.org.musinsa.domain.category.service.dto.response;

import com.tikim.org.musinsa.domain.category.entity.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryServiceUpdateResponse {
    private Long id;
    private String name;

    public static CategoryServiceUpdateResponse from(Category category) {
        return CategoryServiceUpdateResponse.builder()
            .id(category.getId())
            .name(category.getName())
            .build();
    }
}
