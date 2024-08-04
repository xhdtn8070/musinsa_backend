package com.tikim.org.musinsa.unit.brand.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.brand.controller.dto.response.BrandControllerReadResponse;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;

public class BrandControllerReadResponseTest {

    @Test
    @DisplayName("Brand -> BrandServiceReadResponse -> BrandControllerReadResponse 변환 테스트")
    void testFrom() {
        Brand brand = new Brand();
        brand.setId(1L);
        brand.setName("Test Brand");

        BrandServiceReadResponse serviceResponse = BrandServiceReadResponse.from(brand);

        BrandControllerReadResponse controllerResponse = BrandControllerReadResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getName(), controllerResponse.getName());
    }
}
