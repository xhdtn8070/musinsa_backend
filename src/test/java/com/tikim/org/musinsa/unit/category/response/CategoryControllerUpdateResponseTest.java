package com.tikim.org.musinsa.unit.category.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.category.controller.dto.response.CategoryControllerUpdateResponse;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceUpdateResponse;

public class CategoryControllerUpdateResponseTest {

    @Test
    @DisplayName("Category -> CategoryServiceUpdateResponse -> CategoryControllerUpdateResponse 변환 테스트")
    void testFrom() {
        Category category = Category.builder()
            .id(1L)
            .name("Updated Category")
            .build();

        CategoryServiceUpdateResponse serviceResponse = CategoryServiceUpdateResponse.from(category);

        CategoryControllerUpdateResponse controllerResponse = CategoryControllerUpdateResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
