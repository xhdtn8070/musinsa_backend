package com.tikim.org.musinsa.integration.brand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.brand.service.BrandService;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceCreateResponse;

import jakarta.transaction.Transactional;

@Transactional
@SpringBootTest
public class BrandServiceIntegrationTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    void clearDatabase() {
        brandRepository.deleteAll();
    }

    @Test
    @DisplayName("createBrand 통합 테스트")
    @Rollback
    void testCreateBrand() {
        BrandServiceCreateRequest request = BrandServiceCreateRequest.builder().name("Test Brand").build();

        BrandServiceCreateResponse response = brandService.createBrand(request);

        assertNotNull(response.getId());
        assertEquals(request.getName(), response.getName());

        List<Brand> brands = brandRepository.findAll();
        assertEquals(1, brands.size());
        assertEquals("Test Brand", brands.get(0).getName());
    }
}
