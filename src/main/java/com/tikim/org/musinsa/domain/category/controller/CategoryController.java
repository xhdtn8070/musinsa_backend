package com.tikim.org.musinsa.domain.category.controller;

import com.tikim.org.musinsa.domain.category.dto.CreateCategoryRequest;
import com.tikim.org.musinsa.domain.category.dto.UpdateCategoryRequest;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody UpdateCategoryRequest request) {
        return categoryService.updateCategory(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
