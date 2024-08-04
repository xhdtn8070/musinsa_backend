package com.tikim.org.musinsa.domain.product.service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByBrand;

@Getter
@Setter
public class ProductServiceMinPriceByBrandResponse {
    private String brandName;
    private List<CategoryPrice> categoryPrices;
    private int totalAmount;

    @Getter
    @Setter
    public static class CategoryPrice {
        private String category;
        private int price;
    }

    public static ProductServiceMinPriceByBrandResponse from(List<MinPriceProductByBrand> minPriceProducts) {
        ProductServiceMinPriceByBrandResponse response = new ProductServiceMinPriceByBrandResponse();
        response.setBrandName(minPriceProducts.get(0).getBrandName());
        response.setCategoryPrices(minPriceProducts.stream().map(p -> {
            CategoryPrice categoryPrice = new CategoryPrice();
            categoryPrice.setCategory(p.getCategoryName());
            categoryPrice.setPrice(p.getPrice());
            return categoryPrice;
        }).collect(Collectors.toList()));
        response.setTotalAmount(minPriceProducts.stream().mapToInt(MinPriceProductByBrand::getPrice).sum());
        return response;
    }
}
