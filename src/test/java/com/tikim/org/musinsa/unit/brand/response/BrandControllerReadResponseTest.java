package com.tikim.org.musinsa.unit.brand.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.brand.controller.dto.response.BrandControllerReadResponse;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;

@SpringBootTest
@ActiveProfiles("test")
public class BrandControllerReadResponseTest {

    @Test
    @DisplayName("BrandServiceReadResponse -> BrandControllerReadResponse 변환 테스트")
    void testReadResponseConversion() {
        Brand brand = Brand.builder()
            .id(1L)
            .name("Test Brand")
            .build();
        BrandServiceReadResponse serviceResponse = BrandServiceReadResponse.from(brand);

        BrandControllerReadResponse controllerResponse = BrandControllerReadResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
