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
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;

@SpringBootTest
@Transactional
public class CategoryServiceGetCategoryByIdTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    private final Long nonExistentId = -1L;

    private Long savedCategoryId;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        categoryRepository.flush();

        Category category = categoryRepository.save(Category.builder().name("Test Category").build());
        savedCategoryId = category.getId();
    }

    @Test
    @DisplayName("카테고리 ID로 조회 테스트")
    void testGetCategoryById_Success() {
        CategoryServiceReadResponse response = categoryService.getCategoryById(savedCategoryId);
        assertEquals("Test Category", response.getName());
    }

    @Test
    @DisplayName("존재하지 않는 카테고리 조회 시 예외 발생 테스트")
    void testGetCategoryById_NotFound() {
        assertThrows(CategoryException.class, () -> categoryService.getCategoryById(nonExistentId));
    }
}
