package com.tikim.org.musinsa.domain.category.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryControllerUpdateRequest {
    private String name;

    @Builder
    public CategoryControllerUpdateRequest(String name) {
        this.name = name;
    }
}
