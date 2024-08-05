package com.tikim.org.musinsa.unit.product.request;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.request.ProductControllerUpdateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceUpdateRequest;

public class ProductControllerUpdateRequestTest {

    @Test
    @DisplayName("ProductControllerUpdateRequest -> ProductServiceUpdateRequest 변환 테스트")
    void testFrom() {
        ProductControllerUpdateRequest controllerRequest = ProductControllerUpdateRequest.builder()
            .categoryId(1L)
            .brandId(1L)
            .price(20000)
            .build();

        ProductServiceUpdateRequest serviceRequest = ProductServiceUpdateRequest.from(controllerRequest);

        assertEquals(controllerRequest.getCategoryId(), serviceRequest.getCategoryId());
        assertEquals(controllerRequest.getBrandId(), serviceRequest.getBrandId());
        assertEquals(controllerRequest.getPrice(), serviceRequest.getPrice());
    }
}
