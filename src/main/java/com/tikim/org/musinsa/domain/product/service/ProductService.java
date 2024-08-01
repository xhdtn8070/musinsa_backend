package com.tikim.org.musinsa.domain.product.service;

import com.tikim.org.musinsa.domain.product.dto.CategoryMinMaxPrice;
import com.tikim.org.musinsa.domain.product.dto.MinPriceByCategoryResponse;
import com.tikim.org.musinsa.domain.product.dto.MinPriceByBrandResponse;
import com.tikim.org.musinsa.domain.product.dto.CategoryMinMaxPriceResponse;
import com.tikim.org.musinsa.domain.product.dto.MinPriceProductByBrand;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.global.exception.exceptions.BaseException;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<MinPriceByCategoryResponse> findMinPriceProductsByCategory() {
        return productRepository.findMinPriceProductsByCategory().stream()
                .map(p -> new MinPriceByCategoryResponse(p.getId(), p.getBrandId(), p.getCategoryId(), p.getPrice()))
                .collect(Collectors.toList());
    }

    public MinPriceByBrandResponse findMinPriceProductsByBrand() {
        List<MinPriceProductByBrand> minPriceProducts = productRepository.findMinPriceProductsByBrand();

        if (minPriceProducts.isEmpty()) {
            throw new BaseException(ErrorMessage.UNDEFINED_EXCEPTION, CriticalLevel.CRITICAL, "No products found") {};
        }

        String brandName = minPriceProducts.get(0).getBrandId().toString(); // 브랜드 이름 얻는 방법 수정 필요
        List<MinPriceByBrandResponse.CategoryPrice> categoryPrices = minPriceProducts.stream()
                .map(p -> new MinPriceByBrandResponse.CategoryPrice(p.getCategoryId().toString(), p.getPrice())) // 카테고리 이름 얻는 방법 수정 필요
                .collect(Collectors.toList());

        int totalAmount = minPriceProducts.stream()
                .mapToInt(MinPriceProductByBrand::getPrice)
                .sum();

        return new MinPriceByBrandResponse(brandName, categoryPrices, totalAmount);
    }

    public CategoryMinMaxPriceResponse findCategoryMinMaxPrice(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
                .orElseThrow(() -> new BaseException(ErrorMessage.UNDEFINED_EXCEPTION, CriticalLevel.CRITICAL, "Category not found") {});

        List<CategoryMinMaxPrice> minMaxPrices = productRepository.findCategoryMinMaxPrice(category.getId());

        List<CategoryMinMaxPriceResponse.BrandPrice> minPrices = minMaxPrices.stream()
                .filter(p -> p.getPrice().equals(minMaxPrices.get(0).getPrice())) // 최저가 필터링 로직 수정 필요
                .map(p -> new CategoryMinMaxPriceResponse.BrandPrice(p.getBrandName(), p.getPrice()))
                .collect(Collectors.toList());

        List<CategoryMinMaxPriceResponse.BrandPrice> maxPrices = minMaxPrices.stream()
                .filter(p -> p.getPrice().equals(minMaxPrices.get(minMaxPrices.size() - 1).getPrice())) // 최고가 필터링 로직 수정 필요
                .map(p -> new CategoryMinMaxPriceResponse.BrandPrice(p.getBrandName(), p.getPrice()))
                .collect(Collectors.toList());

        return new CategoryMinMaxPriceResponse(categoryName, minPrices, maxPrices);
    }
}
