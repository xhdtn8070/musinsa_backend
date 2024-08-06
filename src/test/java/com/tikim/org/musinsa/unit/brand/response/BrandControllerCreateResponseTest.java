package com.tikim.org.musinsa.unit.brand.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.brand.controller.dto.response.BrandControllerCreateResponse;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceCreateResponse;

@SpringBootTest
@ActiveProfiles("test")
public class BrandControllerCreateResponseTest {

    @Test
    @DisplayName("BrandServiceCreateResponse -> BrandControllerCreateResponse 변환 테스트")
    void testCreateResponseConversion() {
        Brand brand = Brand.builder()
            .id(1L)
            .name("Test Brand")
            .build();
        BrandServiceCreateResponse serviceResponse = BrandServiceCreateResponse.from(brand);

        BrandControllerCreateResponse controllerResponse = BrandControllerCreateResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
