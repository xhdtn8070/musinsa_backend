package com.tikim.org.musinsa.domain.product.controller.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByBrandResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductControllerMinPriceByBrandResponse {
    private String brandName;
    private List<CategoryPrice> categoryPrices;
    private int totalAmount;

    @Getter
    @Setter
    public static class CategoryPrice {
        private String category;
        private int price;
    }

    public static ProductControllerMinPriceByBrandResponse from(ProductServiceMinPriceByBrandResponse serviceResponse) {
        ProductControllerMinPriceByBrandResponse response = new ProductControllerMinPriceByBrandResponse();
        response.setBrandName(serviceResponse.getBrandName());
        response.setCategoryPrices(serviceResponse.getCategoryPrices().stream().map(cp -> {
            CategoryPrice categoryPrice = new CategoryPrice();
            categoryPrice.setCategory(cp.getCategory());
            categoryPrice.setPrice(cp.getPrice());
            return categoryPrice;
        }).collect(Collectors.toList()));
        response.setTotalAmount(serviceResponse.getTotalAmount());
        return response;
    }
}