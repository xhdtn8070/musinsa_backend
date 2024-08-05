package com.tikim.org.musinsa.unit.product.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerCreateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceCreateRequest;

public class ProductControllerCreateRequestTest {

    @Test
    @DisplayName("ProductControllerCreateRequest -> ProductServiceCreateRequest 변환 테스트")
    void testFrom() {
        ProductControllerCreateRequest controllerRequest = ProductControllerCreateRequest.builder()
            .categoryId(1L)
            .brandId(1L)
            .price(10000)
            .build();

        ProductServiceCreateRequest serviceRequest = ProductServiceCreateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getCategoryId(), serviceRequest.getCategoryId());
        assertEquals(controllerRequest.getBrandId(), serviceRequest.getBrandId());
        assertEquals(controllerRequest.getPrice(), serviceRequest.getPrice());
    }
}
