package com.tikim.org.musinsa.unit.category.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerUpdateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceUpdateRequest;

@SpringBootTest
@ActiveProfiles("test")
public class CategoryControllerUpdateRequestTest {

    @Test
    @DisplayName("CategoryControllerUpdateRequest -> CategoryServiceUpdateRequest 변환 테스트")
    void testFrom() {
        CategoryControllerUpdateRequest controllerRequest = CategoryControllerUpdateRequest.builder()
            .name("Updated Category")
            .build();

        CategoryServiceUpdateRequest serviceRequest = CategoryServiceUpdateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getName(), serviceRequest.getName());
    }
}
