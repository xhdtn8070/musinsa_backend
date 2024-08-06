package com.tikim.org.musinsa.integration.category;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.service.CategoryService;
import com.tikim.org.musinsa.global.cache.service.GlobalCacheService;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CategoryServiceDeleteCategoryTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GlobalCacheService globalCacheService;

    private final Long nonExistentId = -1L;

    private Long savedCategoryId;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        categoryRepository.flush();

        Category category = categoryRepository.save(Category.builder().name("Test Category").build());
        savedCategoryId = category.getId();

        globalCacheService.evictAllCaches();
    }

    @Test
    @DisplayName("카테고리 삭제 테스트")
    void testDeleteCategory_Success() {
        categoryService.deleteCategoryById(savedCategoryId);

        assertThrows(CategoryException.class, () -> categoryService.getCategoryById(savedCategoryId));
    }

    @Test
    @DisplayName("존재하지 않는 카테고리 삭제 시 예외 발생 테스트")
    void testDeleteCategory_NotFound() {
        assertThrows(CategoryException.class, () -> categoryService.deleteCategoryById(nonExistentId));
    }
}
