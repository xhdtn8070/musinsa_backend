package com.tikim.org.musinsa.domain.brand.controller;

import com.tikim.org.musinsa.domain.brand.dto.CreateBrandRequest;
import com.tikim.org.musinsa.domain.brand.dto.UpdateBrandRequest;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id);
    }

    @PostMapping
    public Brand createBrand(@RequestBody CreateBrandRequest request) {
        return brandService.createBrand(request);
    }

    @PutMapping("/{id}")
    public Brand updateBrand(@PathVariable Long id, @RequestBody UpdateBrandRequest request) {
        return brandService.updateBrand(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteBrandById(@PathVariable Long id) {
        brandService.deleteBrandById(id);
    }
}
