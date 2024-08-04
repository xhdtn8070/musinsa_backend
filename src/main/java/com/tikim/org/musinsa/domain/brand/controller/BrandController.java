package com.tikim.org.musinsa.domain.brand.controller;

import com.tikim.org.musinsa.domain.brand.dto.BrandResponse;
import com.tikim.org.musinsa.domain.brand.dto.CreateBrandRequest;
import com.tikim.org.musinsa.domain.brand.dto.UpdateBrandRequest;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<List<BrandResponse>> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable Long id) {
        return ResponseEntity.ok(brandService.getBrandById(id));
    }

    @PostMapping
    public ResponseEntity<BrandResponse> createBrand(@RequestBody CreateBrandRequest request) {
        return ResponseEntity.ok(brandService.createBrand(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandResponse> updateBrand(@PathVariable Long id, @RequestBody UpdateBrandRequest request) {
        return ResponseEntity.ok(brandService.updateBrand(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrandById(@PathVariable Long id) {
        brandService.deleteBrandById(id);
        return ResponseEntity.noContent().build();
    }
}
