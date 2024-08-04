package com.tikim.org.musinsa.domain.category.service;

import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceCreateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceUpdateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceCreateResponse;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceUpdateResponse;
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
    public List<CategoryServiceReadResponse> getAllCategories() {
        return categoryRepository.findAll().stream()
            .map(CategoryServiceReadResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryServiceReadResponse getCategoryById(Long id) {
        return categoryRepository.findById(id)
            .map(CategoryServiceReadResponse::from)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Transactional
    public CategoryServiceCreateResponse createCategory(CategoryServiceCreateRequest request) {
        Category category = Category.from(request);
        return CategoryServiceCreateResponse.from(categoryRepository.save(category));
    }

    @Transactional
    public CategoryServiceUpdateResponse updateCategory(Long id, CategoryServiceUpdateRequest request) {
        Category existingCategory = categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        existingCategory.update(request);
        return CategoryServiceUpdateResponse.from(categoryRepository.save(existingCategory));
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
