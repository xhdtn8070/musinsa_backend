package com.tikim.org.musinsa.unit.category.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerCreateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceCreateRequest;

public class CategoryControllerCreateRequestTest {

    @Test
    @DisplayName("CategoryControllerCreateRequest -> CategoryServiceCreateRequest 변환 테스트")
    void testFrom() {
        CategoryControllerCreateRequest controllerRequest = CategoryControllerCreateRequest.builder()
            .name("New Category")
            .build();

        CategoryServiceCreateRequest serviceRequest = CategoryServiceCreateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getName(), serviceRequest.getName());
    }
}
