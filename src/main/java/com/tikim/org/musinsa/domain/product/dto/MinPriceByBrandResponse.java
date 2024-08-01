package com.tikim.org.musinsa.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class MinPriceByBrandResponse {
    private String brandName;
    private List<CategoryPrice> categoryPrices;
    private Integer totalAmount;

    @Data
    @AllArgsConstructor
    public static class CategoryPrice {
        private String category;
        private Integer price;
    }
}
