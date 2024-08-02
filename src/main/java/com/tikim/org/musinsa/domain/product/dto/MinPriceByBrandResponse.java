package com.tikim.org.musinsa.domain.product.dto;

import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import java.util.List;
import java.util.stream.Collectors;

public record MinPriceByBrandResponse(String brandName, List<CategoryPrice> categoryPrices, Integer totalAmount) {

    public record CategoryPrice(String category, Integer price) {

    }

    public static MinPriceByBrandResponse from(List<MinPriceProductByBrand> minPriceProducts) {
        if (minPriceProducts.isEmpty()) {
            throw new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.NON_CRITICAL);
        }

        String brandName = minPriceProducts.get(0).getBrandName();
        List<CategoryPrice> categoryPrices = minPriceProducts.stream()
            .map(p -> new CategoryPrice(p.getCategoryName(), p.getPrice()))
            .collect(Collectors.toList());
        int totalAmount = minPriceProducts.stream()
            .mapToInt(MinPriceProductByBrand::getPrice)
            .sum();

        return new MinPriceByBrandResponse(brandName, categoryPrices, totalAmount);
    }
}
