package com.tikim.org.musinsa.domain.product.controller;

import com.tikim.org.musinsa.domain.product.dto.*;
import com.tikim.org.musinsa.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/min-price-by-category")
    public ResponseEntity<List<MinPriceByCategoryResponse>> getMinPriceProductsByCategory() {
        return ResponseEntity.ok(productService.getMinPriceProductsByCategory());
    }

    @GetMapping("/min-price-by-brand")
    public ResponseEntity<MinPriceByBrandResponse> getMinPriceProductsByBrand() {
        return ResponseEntity.ok(productService.getMinPriceProductsByBrand());
    }

    @GetMapping("/min-max-price-by-category")
    public ResponseEntity<CategoryMinMaxPriceResponse> getCategoryMinMaxPrice(@RequestParam String categoryName) {
        return ResponseEntity.ok(productService.getCategoryMinMaxPrice(categoryName));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }
}
