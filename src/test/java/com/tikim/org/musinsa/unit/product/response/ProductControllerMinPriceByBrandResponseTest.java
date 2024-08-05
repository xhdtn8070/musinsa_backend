package com.tikim.org.musinsa.unit.product.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tikim.org.musinsa.domain.product.controller.dto.response.ProductControllerMinPriceByBrandResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByBrandResponse;

public class ProductControllerMinPriceByBrandResponseTest {

    @Test
    @DisplayName("ProductServiceMinPriceByBrandResponse -> ProductControllerMinPriceByBrandResponse 변환 테스트")
    void testFrom() {
        ProductServiceMinPriceByBrandResponse serviceResponse = ProductServiceMinPriceByBrandResponse.builder()
            .brandName("Test Brand")
            .categoryPrices(List.of(ProductServiceMinPriceByBrandResponse.CategoryPrice.builder()
                .category("Test Category")
                .price(5000)
                .build()))
            .totalAmount(5000)
            .build();

        ProductControllerMinPriceByBrandResponse controllerResponse = ProductControllerMinPriceByBrandResponse.from(serviceResponse);

        assertEquals(serviceResponse.getBrandName(), controllerResponse.getBrandName());
        assertEquals(serviceResponse.getCategoryPrices().get(0).getCategory(), controllerResponse.getCategoryPrices().get(0).getCategory());
        assertEquals(serviceResponse.getCategoryPrices().get(0).getPrice(), controllerResponse.getCategoryPrices().get(0).getPrice());
        assertEquals(serviceResponse.getTotalAmount(), controllerResponse.getTotalAmount());
    }
}
