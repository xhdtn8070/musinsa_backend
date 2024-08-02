package com.tikim.org.musinsa.domain.category.service;

import com.tikim.org.musinsa.domain.category.dto.CreateCategoryRequest;
import com.tikim.org.musinsa.domain.category.dto.UpdateCategoryRequest;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Transactional
    public Category createCategory(CreateCategoryRequest request) {
        Category category = Category.from(request);
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Long id, UpdateCategoryRequest request) {
        Category existingCategory = getCategoryById(id);
        existingCategory.update(request);
        return categoryRepository.save(existingCategory);
    }

    @Transactional
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
