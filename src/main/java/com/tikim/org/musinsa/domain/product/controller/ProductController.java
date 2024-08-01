package com.tikim.org.musinsa.domain.product.controller;

import com.tikim.org.musinsa.domain.product.dto.MinPriceByCategoryResponse;
import com.tikim.org.musinsa.domain.product.dto.MinPriceByBrandResponse;
import com.tikim.org.musinsa.domain.product.dto.CategoryMinMaxPriceResponse;
import com.tikim.org.musinsa.domain.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/min-price-by-category")
    public ResponseEntity<List<MinPriceByCategoryResponse>> findMinPriceProductsByCategory() {
        return ResponseEntity.ok(productService.findMinPriceProductsByCategory());
    }

    @GetMapping("/min-price-by-brand")
    public ResponseEntity<MinPriceByBrandResponse> findMinPriceProductsByBrand() {
        return ResponseEntity.ok(productService.findMinPriceProductsByBrand());
    }

    @GetMapping("/min-max-price-by-category")
    public ResponseEntity<CategoryMinMaxPriceResponse> findCategoryMinMaxPrice(@RequestParam String categoryName) {
        return ResponseEntity.ok(productService.findCategoryMinMaxPrice(categoryName));
    }
}
