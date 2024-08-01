package com.tikim.org.musinsa.domain.brand.controller;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public List<Brand> findAll() {
        return brandService.findAll();
    }

    @GetMapping("/{id}")
    public Brand findById(@PathVariable Long id) {
        return brandService.findById(id);
    }

    @PostMapping
    public Brand save(@RequestBody Brand brand) {
        return brandService.save(brand);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        brandService.deleteById(id);
    }
}
