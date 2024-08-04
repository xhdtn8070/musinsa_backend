package com.tikim.org.musinsa.integration.brand;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.exception.BrandException;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;

@SpringBootTest
@Transactional
public class BrandServiceDeleteBrandByIdTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    private final Long nonExistentId = -1L;

    private Long savedBrandId;

    @BeforeEach
    void setUp() {
        brandRepository.deleteAll();
        Brand brand = brandRepository.save(Brand.builder().name("Brand1").build());
        savedBrandId = brand.getId();
    }

    @Test
    @DisplayName("브랜드 삭제 테스트")
    void testDeleteBrandById() {
        brandService.deleteBrandById(savedBrandId);

        assertThrows(BrandException.class, () -> brandService.getBrandById(savedBrandId));
    }

    @Test
    @DisplayName("존재하지 않는 브랜드 삭제 시 예외 발생 테스트")
    void testDeleteBrandById_NotFound() {
        assertThrows(BrandException.class, () -> brandService.deleteBrandById(nonExistentId));
    }
}
