package com.tikim.org.musinsa.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MinPriceByCategoryResponse {
    private Long id;
    private Long brandId;
    private Long categoryId;
    private Integer price;
}
