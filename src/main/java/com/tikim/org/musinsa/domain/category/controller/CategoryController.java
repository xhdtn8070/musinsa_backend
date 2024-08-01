package com.tikim.org.musinsa.domain.category.controller;

import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
