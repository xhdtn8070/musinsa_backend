package com.tikim.org.musinsa.domain.product.service;

import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.product.dto.CategoryMinMaxPrice;
import com.tikim.org.musinsa.domain.product.dto.MinPriceByBrandResponse;
import com.tikim.org.musinsa.domain.product.dto.MinPriceByCategoryResponse;
import com.tikim.org.musinsa.domain.product.dto.CategoryMinMaxPriceResponse;
import com.tikim.org.musinsa.domain.product.dto.MinPriceProductByBrand;
import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import com.tikim.org.musinsa.global.exception.exceptions.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<MinPriceByCategoryResponse> findMinPriceProductsByCategory() {
        return productRepository.findMinPriceProductsByCategory().stream()
            .map(p -> new MinPriceByCategoryResponse(p.getCategoryName(), p.getBrandName(), p.getPrice()))
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MinPriceByBrandResponse findMinPriceProductsByBrand() {
        List<MinPriceProductByBrand> minPriceProducts = productRepository.findMinPriceProductsByBrand();

        if (minPriceProducts.isEmpty()) {
            throw new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.CRITICAL) {
            };
        }

        String brandName = minPriceProducts.get(0).getBrandName();
        List<MinPriceByBrandResponse.CategoryPrice> categoryPrices = mapToCategoryPrices(minPriceProducts);
        int totalAmount = calculateTotalAmount(minPriceProducts);

        return new MinPriceByBrandResponse(brandName, categoryPrices, totalAmount);
    }

    private List<MinPriceByBrandResponse.CategoryPrice> mapToCategoryPrices(List<MinPriceProductByBrand> minPriceProducts) {
        return minPriceProducts.stream()
            .map(p -> new MinPriceByBrandResponse.CategoryPrice(p.getCategoryName(), p.getPrice()))
            .collect(Collectors.toList());
    }

    private int calculateTotalAmount(List<MinPriceProductByBrand> minPriceProducts) {
        return minPriceProducts.stream()
            .mapToInt(MinPriceProductByBrand::getPrice)
            .sum();
    }

    @Transactional(readOnly = true)
    public CategoryMinMaxPriceResponse findCategoryMinMaxPrice(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL) {
            });

        CategoryMinMaxPrice minPrice = productRepository.findMinPriceByCategory(category.getId())
            .orElseThrow(() -> new ProductException(ErrorMessage.MIN_PRICE_NOT_FOUND, CriticalLevel.CRITICAL, "Min price not found") {
            });

        CategoryMinMaxPrice maxPrice = productRepository.findMaxPriceByCategory(category.getId())
            .orElseThrow(() -> new ProductException(ErrorMessage.MAX_PRICE_NOT_FOUND, CriticalLevel.CRITICAL, "Max price not found") {
            });

        return CategoryMinMaxPriceResponse.from(categoryName, minPrice, maxPrice);
    }

}
