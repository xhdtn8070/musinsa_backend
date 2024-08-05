package com.tikim.org.musinsa.domain.product.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ProductControllerUpdateRequest {
    private Long categoryId;
    private Long brandId;
    private int price;

    @Builder
    public ProductControllerUpdateRequest(Long categoryId, Long brandId, int price) {
        this.categoryId = categoryId;
        this.brandId = brandId;
        this.price = price;
    }
}