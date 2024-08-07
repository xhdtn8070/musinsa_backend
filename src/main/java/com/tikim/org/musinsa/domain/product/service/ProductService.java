package com.tikim.org.musinsa.domain.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.exception.BrandException;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.entity.Product;
import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.product.repository.dto.response.CategoryMinMaxPrice;
import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByBrand;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceCreateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.request.ProductServiceUpdateRequest;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCategoryMinMaxPriceResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceCreateResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByBrandResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceMinPriceByCategoryResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceReadResponse;
import com.tikim.org.musinsa.domain.product.service.dto.response.ProductServiceUpdateResponse;
import com.tikim.org.musinsa.global.cache.CacheNames;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Caching(cacheable = {
        @Cacheable(value = CacheNames.PRODUCT_ALL, key = "'MinPriceProductsByCategory'")
    })
    @Transactional(readOnly = true)
    public List<ProductServiceMinPriceByCategoryResponse> getMinPriceProductsByCategory() {
        return productRepository.findMinPriceProductsByCategory().stream()
            .map(ProductServiceMinPriceByCategoryResponse::from)
            .collect(Collectors.toList());
    }

    @Caching(cacheable = {
        @Cacheable(value = CacheNames.PRODUCT_ALL, key = "'MinPriceProductsByBrand'")
    })
    @Transactional(readOnly = true)
    public ProductServiceMinPriceByBrandResponse getMinPriceProductsByBrand() {
        List<MinPriceProductByBrand> minPriceProducts = productRepository.findMinPriceProductsByBrand();
        return ProductServiceMinPriceByBrandResponse.from(minPriceProducts);
    }

    @Caching(cacheable = {
        @Cacheable(value = CacheNames.PRODUCT_ALL, key = "'CategoryMinMaxPrice::' + #categoryName")
    })
    @Transactional(readOnly = true)
    public ProductServiceCategoryMinMaxPriceResponse getCategoryMinMaxPrice(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        CategoryMinMaxPrice minPrice = productRepository.findMinPriceByCategory(category.getId())
            .orElseThrow(() -> new ProductException(ErrorMessage.MIN_PRICE_NOT_FOUND, CriticalLevel.NON_CRITICAL));

        CategoryMinMaxPrice maxPrice = productRepository.findMaxPriceByCategory(category.getId())
            .orElseThrow(() -> new ProductException(ErrorMessage.MAX_PRICE_NOT_FOUND, CriticalLevel.NON_CRITICAL));

        return ProductServiceCategoryMinMaxPriceResponse.from(categoryName, minPrice, maxPrice);
    }

    @Caching(cacheable = {
        @Cacheable(value = CacheNames.PRODUCT_ALL, key = "'ALL'")
    })
    @Transactional(readOnly = true)
    public List<ProductServiceReadResponse> getAllProducts() {
        return productRepository.findAll().stream()
            .map(ProductServiceReadResponse::from)
            .collect(Collectors.toList());
    }

    @Caching(cacheable = {
        @Cacheable(value = CacheNames.PRODUCT_ONE, key = "#id")
    })
    @Transactional(readOnly = true)
    public ProductServiceReadResponse getProductById(Long id) {
        return productRepository.findById(id)
            .map(ProductServiceReadResponse::from)
            .orElseThrow(() -> new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Caching(evict = {
        @CacheEvict(value = CacheNames.PRODUCT_ALL, allEntries = true)
    })
    @Transactional
    public ProductServiceCreateResponse createProduct(ProductServiceCreateRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        Brand brand = brandRepository.findById(request.getBrandId())
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        Product product = Product.from(request, category, brand);
        return ProductServiceCreateResponse.from(productRepository.save(product));
    }

    @Caching(
        evict = {
            @CacheEvict(value = CacheNames.PRODUCT_ONE, key = "#id"),
            @CacheEvict(value = CacheNames.PRODUCT_ALL, allEntries = true)
        })
    @Transactional
    public ProductServiceUpdateResponse updateProduct(Long id, ProductServiceUpdateRequest request) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        Category category = categoryRepository.findById(request.getCategoryId())
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        Brand brand = brandRepository.findById(request.getBrandId())
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        product.update(request, category, brand);
        return ProductServiceUpdateResponse.from(productRepository.save(product));
    }

    @Caching(evict = {
        @CacheEvict(value = CacheNames.PRODUCT_ONE, key = "#id"),
        @CacheEvict(value = CacheNames.PRODUCT_ALL, allEntries = true)
    })
    @Transactional
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        productRepository.delete(product);
    }
}
