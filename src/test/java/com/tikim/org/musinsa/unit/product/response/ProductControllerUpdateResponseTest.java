package com.tikim.org.musinsa.unit.product.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.response.ProductControllerUpdateResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceUpdateResponse;

public class ProductControllerUpdateResponseTest {

    @Test
    @DisplayName("ProductServiceUpdateResponse -> ProductControllerUpdateResponse 변환 테스트")
    void testFrom() {
        ProductServiceUpdateResponse serviceResponse = ProductServiceUpdateResponse.builder()
            .id(1L)
            .categoryId(1L)
            .brandId(1L)
            .price(2000)
            .build();

        ProductControllerUpdateResponse controllerResponse = ProductControllerUpdateResponse.from(serviceResponse);

        assertEquals(serviceResponse.getId(), controllerResponse.getId());
        assertEquals(serviceResponse.getCategoryId(), controllerResponse.getCategoryId());
        assertEquals(serviceResponse.getBrandId(), controllerResponse.getBrandId());
        assertEquals(serviceResponse.getPrice(), controllerResponse.getPrice());
    }
}
