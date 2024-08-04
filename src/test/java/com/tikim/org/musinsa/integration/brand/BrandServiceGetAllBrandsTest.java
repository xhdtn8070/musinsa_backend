package com.tikim.org.musinsa.integration.brand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.service.BrandService;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;

@SpringBootTest
@Transactional
public class BrandServiceGetAllBrandsTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    void setUp() {
        brandRepository.deleteAll();
        brandRepository.save(Brand.builder().name("Brand1").build());
        brandRepository.save(Brand.builder().name("Brand2").build());
    }

    @Test
    @DisplayName("모든 브랜드 조회 테스트")
    void testGetAllBrands() {
        List<BrandServiceReadResponse> brands = brandService.getAllBrands();
        assertEquals(2, brands.size());
        assertTrue(brands.stream().anyMatch(brand -> brand.getName().equals("Brand1")));
        assertTrue(brands.stream().anyMatch(brand -> brand.getName().equals("Brand2")));
    }
}
