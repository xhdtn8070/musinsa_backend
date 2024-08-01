package com.tikim.org.musinsa.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MinPriceByCategoryResponse {
    private String categoryName;
    private String brandName;
    private Integer price;
}
