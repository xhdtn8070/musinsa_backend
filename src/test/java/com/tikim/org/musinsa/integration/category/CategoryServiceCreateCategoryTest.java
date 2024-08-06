package com.tikim.org.musinsa.integration.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.service.CategoryService;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceCreateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceCreateResponse;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;
import com.tikim.org.musinsa.global.cache.service.GlobalCacheService;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CategoryServiceCreateCategoryTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GlobalCacheService globalCacheService;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        categoryRepository.flush();

        globalCacheService.evictAllCaches();
    }

    @Test
    @DisplayName("카테고리 생성 및 조회 테스트")
    void testCreateCategory() {
        // 카테고리 생성 요청
        CategoryServiceCreateRequest request = CategoryServiceCreateRequest.builder()
            .name("New Category")
            .build();

        // 카테고리 생성 응답
        CategoryServiceCreateResponse createResponse = categoryService.createCategory(request);

        // 생성된 카테고리의 ID와 이름이 요청과 일치하는지 확인
        assertNotNull(createResponse.getId());
        assertEquals("New Category", createResponse.getName());

        // 생성된 카테고리를 ID로 다시 조회
        CategoryServiceReadResponse readResponse = categoryService.getCategoryById(createResponse.getId());

        // 조회한 카테고리의 ID와 이름이 생성된 카테고리와 일치하는지 확인
        assertEquals(createResponse.getId(), readResponse.getId());
        assertEquals("New Category", readResponse.getName());
    }
}
