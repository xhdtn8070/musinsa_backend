package com.tikim.org.musinsa.unit.category.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.category.controller.dto.response.CategoryControllerReadResponse;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryControllerReadResponseTest {

    @Test
    @DisplayName("Category -> CategoryServiceReadResponse -> CategoryControllerReadResponse 변환 테스트")
    void testFrom() {
        Category category = Category.builder()
            .id(1L)
            .name("Test Category")
            .build();

        CategoryServiceReadResponse serviceResponse = CategoryServiceReadResponse.from(category);

        CategoryControllerReadResponse controllerResponse = CategoryControllerReadResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
