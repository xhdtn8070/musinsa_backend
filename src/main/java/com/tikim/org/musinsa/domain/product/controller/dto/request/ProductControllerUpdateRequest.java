package com.tikim.org.musinsa.domain.product.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerUpdateRequest {
    private Long categoryId;
    private Long brandId;
    private int price;
}