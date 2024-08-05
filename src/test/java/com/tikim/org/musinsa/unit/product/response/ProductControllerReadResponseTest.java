package com.tikim.org.musinsa.unit.product.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.response.ProductControllerReadResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceReadResponse;

public class ProductControllerReadResponseTest {

    @Test
    @DisplayName("ProductServiceReadResponse -> ProductControllerReadResponse 변환 테스트")
    void testFrom() {
        ProductServiceReadResponse serviceResponse = ProductServiceReadResponse.builder()
            .id(1L)
            .brandName("Test Brand")
            .categoryName("Test Category")
            .price(10000)
            .build();

        ProductControllerReadResponse controllerResponse = ProductControllerReadResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getBrandName(), controllerResponse.getBrandName());
        assertEquals(serviceResponse.getCategoryName(), controllerResponse.getCategoryName());
        assertEquals(serviceResponse.getPrice(), controllerResponse.getPrice());
    }
}
