package com.tikim.org.musinsa.unit.product.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.response.ProductControllerMinPriceByCategoryResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByCategoryResponse;

public class ProductControllerMinPriceByCategoryResponseTest {

    @Test
    @DisplayName("ProductServiceMinPriceByCategoryResponse -> ProductControllerMinPriceByCategoryResponse 변환 테스트")
    void testFrom() {
        ProductServiceMinPriceByCategoryResponse serviceResponse = ProductServiceMinPriceByCategoryResponse.builder()
            .categoryName("Test Category")
            .brandName("Test Brand")
            .price(5000)
            .build();

        ProductControllerMinPriceByCategoryResponse controllerResponse = ProductControllerMinPriceByCategoryResponse.from(serviceResponse);

        assertEquals(serviceResponse.getCategoryName(), controllerResponse.getCategoryName());
        assertEquals(serviceResponse.getBrandName(), controllerResponse.getBrandName());
        assertEquals(serviceResponse.getPrice(), controllerResponse.getPrice());
    }
}
