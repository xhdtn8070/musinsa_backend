package com.tikim.org.musinsa.unit.brand.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.brand.controller.dto.response.BrandControllerUpdateResponse;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceUpdateResponse;

@SpringBootTest
@ActiveProfiles("test")
public class BrandControllerUpdateResponseTest {

    @Test
    @DisplayName("BrandServiceUpdateResponse -> BrandControllerUpdateResponse 변환 테스트")
    void testUpdateResponseConversion() {
        Brand brand = Brand.builder()
            .id(1L)
            .name("Updated Brand")
            .build();
        BrandServiceUpdateResponse serviceResponse = BrandServiceUpdateResponse.from(brand);

        BrandControllerUpdateResponse controllerResponse = BrandControllerUpdateResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
