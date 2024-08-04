package com.tikim.org.musinsa.integration.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.service.CategoryService;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceUpdateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceUpdateResponse;

@SpringBootTest
@Transactional
public class CategoryServiceUpdateCategoryTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    private final Long nonExistentId = -1L;

    private Long savedCategoryId;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        Category category = categoryRepository.save(Category.builder().name("Old Category").build());
        savedCategoryId = category.getId();
    }

    @Test
    @DisplayName("카테고리 업데이트 테스트")
    void testUpdateCategory() {
        CategoryServiceUpdateRequest request = CategoryServiceUpdateRequest.builder()
            .name("Updated Category")
            .build();

        CategoryServiceUpdateResponse response = categoryService.updateCategory(savedCategoryId, request);

        assertEquals(savedCategoryId, response.getId());
        assertEquals("Updated Category", response.getName());
    }

    @Test
    @DisplayName("존재하지 않는 카테고리 업데이트 시 예외 발생 테스트")
    void testUpdateCategory_NotFound() {
        CategoryServiceUpdateRequest request = CategoryServiceUpdateRequest.builder()
            .name("Updated Category")
            .build();

        assertThrows(CategoryException.class, () -> categoryService.updateCategory(nonExistentId, request));
    }
}
