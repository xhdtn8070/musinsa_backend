package com.tikim.org.musinsa.domain.category.controller;

import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerCreateRequest;
import com.tikim.org.musinsa.domain.category.controller.dto.request.CategoryControllerUpdateRequest;
import com.tikim.org.musinsa.domain.category.controller.dto.response.CategoryControllerCreateResponse;
import com.tikim.org.musinsa.domain.category.controller.dto.response.CategoryControllerReadResponse;
import com.tikim.org.musinsa.domain.category.controller.dto.response.CategoryControllerUpdateResponse;
import com.tikim.org.musinsa.domain.category.service.CategoryService;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceCreateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceUpdateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceCreateResponse;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceReadResponse;
import com.tikim.org.musinsa.domain.category.service.dto.response.CategoryServiceUpdateResponse;
import com.tikim.org.musinsa.global.application.dto.ApiResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryControllerReadResponse>>> getAllCategories() {
        List<CategoryServiceReadResponse> serviceResponse = categoryService.getAllCategories();
        List<CategoryControllerReadResponse> response = serviceResponse.stream()
            .map(CategoryControllerReadResponse::from)
            .collect(Collectors.toList());
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryControllerReadResponse>> getCategoryById(@PathVariable Long id) {
        CategoryServiceReadResponse serviceResponse = categoryService.getCategoryById(id);
        CategoryControllerReadResponse response = CategoryControllerReadResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryControllerCreateResponse>> createCategory(@RequestBody CategoryControllerCreateRequest request) {
        CategoryServiceCreateRequest serviceRequest = CategoryServiceCreateRequest.from(request);
        CategoryServiceCreateResponse serviceResponse = categoryService.createCategory(serviceRequest);
        CategoryControllerCreateResponse response = CategoryControllerCreateResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryControllerUpdateResponse>> updateCategory(@PathVariable Long id, @RequestBody CategoryControllerUpdateRequest request) {
        CategoryServiceUpdateRequest serviceRequest = CategoryServiceUpdateRequest.from(request);
        CategoryServiceUpdateResponse serviceResponse = categoryService.updateCategory(id, serviceRequest);
        CategoryControllerUpdateResponse response = CategoryControllerUpdateResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return ApiResponse.toResponseEntity(ApiResponse.success());
    }
}
