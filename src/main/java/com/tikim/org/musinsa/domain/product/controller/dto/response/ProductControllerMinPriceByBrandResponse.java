package com.tikim.org.musinsa.domain.product.controller.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByBrandResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductControllerMinPriceByBrandResponse {
    private String brandName;
    private List<CategoryPrice> categoryPrices;
    private int totalAmount;

    @Getter
    @Builder
    public static class CategoryPrice {
        private String category;
        private int price;
    }

    public static ProductControllerMinPriceByBrandResponse from(ProductServiceMinPriceByBrandResponse serviceResponse) {
        return ProductControllerMinPriceByBrandResponse.builder()
            .brandName(serviceResponse.getBrandName())
            .categoryPrices(serviceResponse.getCategoryPrices().stream()
                .map(cp -> CategoryPrice.builder()
                    .category(cp.getCategory())
                    .price(cp.getPrice())
                    .build())
                .collect(Collectors.toList()))
            .totalAmount(serviceResponse.getTotalAmount())
            .build();
    }
}
