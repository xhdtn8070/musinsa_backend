package com.tikim.org.musinsa.domain.product.service.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByBrand;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductServiceMinPriceByBrandResponse {
    private String brandName;
    private List<CategoryPrice> categoryPrices;
    private int totalAmount;

    @Getter
    @Builder
    public static class CategoryPrice {
        private String category;
        private int price;
    }

    public static ProductServiceMinPriceByBrandResponse from(List<MinPriceProductByBrand> minPriceProducts) {
        if(minPriceProducts.isEmpty()){
            throw new ProductException(ErrorMessage.ALL_CATEGORY_PRODUCTS_NOT_EXIST, CriticalLevel.NON_CRITICAL);
        }

        return ProductServiceMinPriceByBrandResponse.builder()
            .brandName(minPriceProducts.get(0).getBrandName())
            .categoryPrices(minPriceProducts.stream().map(p ->
                CategoryPrice.builder()
                    .category(p.getCategoryName())
                    .price(p.getPrice())
                    .build()
            ).collect(Collectors.toList()))
            .totalAmount(minPriceProducts.stream().mapToInt(MinPriceProductByBrand::getPrice).sum())
            .build();
    }
}
