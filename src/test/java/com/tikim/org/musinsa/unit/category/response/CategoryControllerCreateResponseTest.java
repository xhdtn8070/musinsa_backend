package com.tikim.org.musinsa.unit.category.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.category.controller.dto.response.CategoryControllerCreateResponse;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceCreateResponse;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryControllerCreateResponseTest {

    @Test
    @DisplayName("Category -> CategoryServiceCreateResponse -> CategoryControllerCreateResponse 변환 테스트")
    void testFrom() {
        Category category = Category.builder()
            .id(1L)
            .name("New Category")
            .build();

        CategoryServiceCreateResponse serviceResponse = CategoryServiceCreateResponse.from(category);

        CategoryControllerCreateResponse controllerResponse = CategoryControllerCreateResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
