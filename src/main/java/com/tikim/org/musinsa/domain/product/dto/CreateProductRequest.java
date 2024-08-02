package com.tikim.org.musinsa.domain.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {
    private Long categoryId;
    private Long brandId;
    private int price;
}