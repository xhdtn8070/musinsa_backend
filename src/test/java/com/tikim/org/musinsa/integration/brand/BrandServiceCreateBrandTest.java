package com.tikim.org.musinsa.integration.brand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.service.BrandService;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceCreateResponse;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;

@SpringBootTest
@Transactional
public class BrandServiceCreateBrandTest {

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandRepository brandRepository;

    @BeforeEach
    void setUp() {
        brandRepository.deleteAll();
    }

    @Test
    @DisplayName("브랜드 생성 테스트")
    void testCreateBrand() {
        BrandServiceCreateRequest request = BrandServiceCreateRequest.builder()
            .name("New Brand")
            .build();

        BrandServiceCreateResponse createResponse = brandService.createBrand(request);

        assertNotNull(createResponse.getId());
        assertEquals("New Brand", createResponse.getName());

        // 생성된 브랜드를 다시 조회하여 값이 일치하는지 확인
        BrandServiceReadResponse readResponse = brandService.getBrandById(createResponse.getId());

        assertEquals(createResponse.getId(), readResponse.getId());
        assertEquals("New Brand", readResponse.getName());
    }
}
