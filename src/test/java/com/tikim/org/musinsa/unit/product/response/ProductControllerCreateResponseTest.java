package com.tikim.org.musinsa.unit.product.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.response.ProductControllerCreateResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCreateResponse;

public class ProductControllerCreateResponseTest {

    @Test
    @DisplayName("ProductServiceCreateResponse -> ProductControllerCreateResponse 변환 테스트")
    void testFrom() {
        ProductServiceCreateResponse serviceResponse = ProductServiceCreateResponse.builder()
            .id(1L)
            .categoryId(1L)
            .brandId(1L)
            .price(1000)
            .build();

        ProductControllerCreateResponse controllerResponse = ProductControllerCreateResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getCategoryId(), controllerResponse.getCategoryId());
        assertEquals(serviceResponse.getBrandId(), controllerResponse.getBrandId());
        assertEquals(serviceResponse.getPrice(), controllerResponse.getPrice());
    }
}
