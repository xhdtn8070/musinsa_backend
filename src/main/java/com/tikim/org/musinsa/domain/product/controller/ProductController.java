package com.tikim.org.musinsa.domain.product.controller;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerCreateRequest;
import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerUpdateRequest;
import com.tikim.org.musinsa.domain.product.controller.dto.response.*;
import com.tikim.org.musinsa.domain.product.service.ProductService;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceCreateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceUpdateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.response.*;
import com.tikim.org.musinsa.global.application.dto.ApiResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/min-price-by-category")
    public ResponseEntity<ApiResponse<List<ProductControllerMinPriceByCategoryResponse>>> getMinPriceProductsByCategory() {
        List<ProductServiceMinPriceByCategoryResponse> serviceResponse = productService.getMinPriceProductsByCategory();
        List<ProductControllerMinPriceByCategoryResponse> response = serviceResponse.stream()
            .map(ProductControllerMinPriceByCategoryResponse::from)
            .collect(Collectors.toList());
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping("/min-price-by-brand")
    public ResponseEntity<ApiResponse<ProductControllerMinPriceByBrandResponse>> getMinPriceProductsByBrand() {
        ProductServiceMinPriceByBrandResponse serviceResponse = productService.getMinPriceProductsByBrand();
        ProductControllerMinPriceByBrandResponse response = ProductControllerMinPriceByBrandResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping("/min-max-price-by-category")
    public ResponseEntity<ApiResponse<ProductControllerCategoryMinMaxPriceResponse>> getCategoryMinMaxPrice(@RequestParam String categoryName) {
        ProductServiceCategoryMinMaxPriceResponse serviceResponse = productService.getCategoryMinMaxPrice(categoryName);
        ProductControllerCategoryMinMaxPriceResponse response = ProductControllerCategoryMinMaxPriceResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductControllerReadResponse>>> getAllProducts() {
        List<ProductServiceReadResponse> serviceResponse = productService.getAllProducts();
        List<ProductControllerReadResponse> response = serviceResponse.stream()
            .map(ProductControllerReadResponse::from)
            .collect(Collectors.toList());
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductControllerReadResponse>> getProductById(@PathVariable Long id) {
        ProductServiceReadResponse serviceResponse = productService.getProductById(id);
        ProductControllerReadResponse response = ProductControllerReadResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductControllerCreateResponse>> createProduct(@RequestBody ProductControllerCreateRequest request) {
        ProductServiceCreateRequest serviceRequest = ProductServiceCreateRequest.from(request);
        ProductServiceCreateResponse serviceResponse = productService.createProduct(serviceRequest);
        ProductControllerCreateResponse response = ProductControllerCreateResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductControllerUpdateResponse>> updateProduct(@PathVariable Long id, @RequestBody ProductControllerUpdateRequest request) {
        ProductServiceUpdateRequest serviceRequest = ProductServiceUpdateRequest.from(request);
        ProductServiceUpdateResponse serviceResponse = productService.updateProduct(id, serviceRequest);
        ProductControllerUpdateResponse response = ProductControllerUpdateResponse.from(serviceResponse);
        return ApiResponse.toResponseEntity(ApiResponse.success(response, HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ApiResponse.toResponseEntity(ApiResponse.success());
    }
}
