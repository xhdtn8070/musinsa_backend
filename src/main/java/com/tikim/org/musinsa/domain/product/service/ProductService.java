package com.tikim.org.musinsa.domain.product.service;

import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.dto.*;
import com.tikim.org.musinsa.domain.product.entity.Product;
import com.tikim.org.musinsa.domain.product.exception.ProductException;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Transactional(readOnly = true)
    public List<MinPriceByCategoryResponse> getMinPriceProductsByCategory() {
        return productRepository.findMinPriceProductsByCategory().stream()
            .map(MinPriceByCategoryResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MinPriceByBrandResponse getMinPriceProductsByBrand() {
        List<MinPriceProductByBrand> minPriceProducts = productRepository.findMinPriceProductsByBrand();
        return MinPriceByBrandResponse.from(minPriceProducts);
    }

    @Transactional(readOnly = true)
    public CategoryMinMaxPriceResponse getCategoryMinMaxPrice(String categoryName) {
        Category category = categoryRepository.findByName(categoryName)
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        CategoryMinMaxPrice minPrice = productRepository.findMinPriceByCategory(category.getId())
            .orElseThrow(() -> new ProductException(ErrorMessage.MIN_PRICE_NOT_FOUND, CriticalLevel.NON_CRITICAL));

        CategoryMinMaxPrice maxPrice = productRepository.findMaxPriceByCategory(category.getId())
            .orElseThrow(() -> new ProductException(ErrorMessage.MAX_PRICE_NOT_FOUND, CriticalLevel.NON_CRITICAL));

        return CategoryMinMaxPriceResponse.from(categoryName, minPrice, maxPrice);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
            .map(ProductResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id)
            .map(ProductResponse::from)
            .orElseThrow(() -> new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Transactional
    public ProductResponse createProduct(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        Brand brand = brandRepository.findById(request.getBrandId())
            .orElseThrow(() -> new ProductException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        Product product = Product.from(request, category, brand);
        return ProductResponse.from(productRepository.save(product));
    }

    @Transactional
    public ProductResponse updateProduct(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductException(ErrorMessage.PRODUCT_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        Category category = categoryRepository.findById(request.getCategoryId())
            .orElseThrow(() -> new CategoryException(ErrorMessage.CATEGORY_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        Brand brand = brandRepository.findById(request.getBrandId())
            .orElseThrow(() -> new ProductException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        product.update(request, category, brand);
        return ProductResponse.from(productRepository.save(product));
    }

    @Transactional
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
