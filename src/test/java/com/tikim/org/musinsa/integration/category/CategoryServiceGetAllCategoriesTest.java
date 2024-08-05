package com.tikim.org.musinsa.integration.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.category.service.CategoryService;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;

@SpringBootTest
@Transactional
public class CategoryServiceGetAllCategoriesTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryRepository.deleteAll();
        categoryRepository.flush();

        categoryRepository.save(Category.builder().name("Category 1").build());
        categoryRepository.save(Category.builder().name("Category 2").build());
    }

    @Test
    @DisplayName("모든 카테고리 조회 테스트")
    void testGetAllCategories() {
        List<CategoryServiceReadResponse> categories = categoryService.getAllCategories();

        assertFalse(categories.isEmpty());
        assertEquals(2, categories.size());
        assertEquals("Category 1", categories.get(0).getName());
        assertEquals("Category 2", categories.get(1).getName());
    }
}
