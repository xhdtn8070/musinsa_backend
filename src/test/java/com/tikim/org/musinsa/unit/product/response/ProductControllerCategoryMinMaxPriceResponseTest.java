package com.tikim.org.musinsa.unit.product.response;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tikim.org.musinsa.domain.product.controller.dto.response.ProductControllerCategoryMinMaxPriceResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCategoryMinMaxPriceResponse;

@SpringBootTest
@ActiveProfiles("test")
public class ProductControllerCategoryMinMaxPriceResponseTest {

    @Test
    @DisplayName("ProductServiceCategoryMinMaxPriceResponse -> ProductControllerCategoryMinMaxPriceResponse 변환 테스트")
    void testFrom() {
        ProductServiceCategoryMinMaxPriceResponse.MinMaxPrice minPrice = ProductServiceCategoryMinMaxPriceResponse.MinMaxPrice.builder()
            .brandName("Min Brand")
            .price(1000)
            .build();

        ProductServiceCategoryMinMaxPriceResponse.MinMaxPrice maxPrice = ProductServiceCategoryMinMaxPriceResponse.MinMaxPrice.builder()
            .brandName("Max Brand")
            .price(5000)
            .build();

        ProductServiceCategoryMinMaxPriceResponse serviceResponse = ProductServiceCategoryMinMaxPriceResponse.builder()
            .categoryName("Test Category")
            .minPrice(minPrice)
            .maxPrice(maxPrice)
            .build();

        ProductControllerCategoryMinMaxPriceResponse controllerResponse = ProductControllerCategoryMinMaxPriceResponse.from(serviceResponse);

        assertEquals(serviceResponse.getCategoryName(), controllerResponse.getCategoryName());
        assertEquals(serviceResponse.getMinPrice().getBrandName(), controllerResponse.getMinPrice().getBrandName());
        assertEquals(serviceResponse.getMinPrice().getPrice(), controllerResponse.getMinPrice().getPrice());
        assertEquals(serviceResponse.getMaxPrice().getBrandName(), controllerResponse.getMaxPrice().getBrandName());
        assertEquals(serviceResponse.getMaxPrice().getPrice(), controllerResponse.getMaxPrice().getPrice());
    }
}
