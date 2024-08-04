package com.tikim.org.musinsa.domain.category.service;

import com.tikim.org.musinsa.domain.category.dto.CategoryResponse;
import com.tikim.org.musinsa.domain.category.dto.CreateCategoryRequest;
import com.tikim.org.musinsa.domain.category.dto.UpdateCategoryRequest;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
            .map(CategoryResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryResponse getCategoryById(Long id) {
        return categoryRepository.findById(id)
            .map(CategoryResponse::from)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Transactional
    public CategoryResponse createCategory(CreateCategoryRequest request) {
        Category category = Category.from(request);
        return CategoryResponse.from(categoryRepository.save(category));
    }

    @Transactional
    public CategoryResponse updateCategory(Long id, UpdateCategoryRequest request) {
        Category existingCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        existingCategory.update(request);
        return CategoryResponse.from(categoryRepository.save(existingCategory));
    }

    @Transactional
    public void deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        if (productRepository.existsByCategoryId(id)) {
            throw new CategoryException(ErrorMessage.CATEGORY_HAS_PRODUCTS, CriticalLevel.NON_CRITICAL);
        }

        categoryRepository.delete(category);
    }
}
