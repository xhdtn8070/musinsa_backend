package com.tikim.org.musinsa.domain.brand.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.exception.BrandException;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceUpdateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceCreateResponse;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceReadResponse;
import com.tikim.org.musinsa.domain.brand.service.dto.response.BrandServiceUpdateResponse;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.global.cache.CacheNames;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    @Caching(
        cacheable = {
            @Cacheable(value = CacheNames.BRAND_ALL, key = "'ALL'")
        })
    @Transactional(readOnly = true)
    public List<BrandServiceReadResponse> getAllBrands() {
        return brandRepository.findAll().stream()
            .map(BrandServiceReadResponse::from)
            .collect(Collectors.toList());
    }

    @Caching(
        cacheable = {
            @Cacheable(value = CacheNames.BRAND_ONE, key = "#id")
        })
    @Transactional(readOnly = true)
    public BrandServiceReadResponse getBrandById(Long id) {
        return brandRepository.findById(id)
            .map(BrandServiceReadResponse::from)
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Caching(
        evict = {
            @CacheEvict(value = CacheNames.BRAND_ALL, allEntries = true),
            @CacheEvict(value = CacheNames.PRODUCT_ALL, allEntries = true)
        })
    @Transactional
    public BrandServiceCreateResponse createBrand(BrandServiceCreateRequest request) {
        Brand brand = Brand.from(request);
        return BrandServiceCreateResponse.from(brandRepository.save(brand));
    }

    @Caching(
        put = {
            @CachePut(value = CacheNames.BRAND_ONE, key = "#id")
        },
        evict = {
            @CacheEvict(value = CacheNames.BRAND_ALL, allEntries = true),
            @CacheEvict(value = CacheNames.PRODUCT_ONE, allEntries = true),
            @CacheEvict(value = CacheNames.PRODUCT_ALL, allEntries = true)
        })
    @Transactional
    public BrandServiceUpdateResponse updateBrand(Long id, BrandServiceUpdateRequest request) {
        Brand existingBrand = brandRepository.findById(id)
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        existingBrand.update(request);
        return BrandServiceUpdateResponse.from(brandRepository.save(existingBrand));
    }

    @Caching(evict = {
        @CacheEvict(value = CacheNames.BRAND_ONE, key = "#id"),
        @CacheEvict(value = CacheNames.BRAND_ALL, allEntries = true),
        @CacheEvict(value = CacheNames.PRODUCT_ONE, allEntries = true),
        @CacheEvict(value = CacheNames.PRODUCT_ALL, allEntries = true)
    })
    @Transactional
    public void deleteBrandById(Long id) {
        Brand brand = brandRepository.findById(id)
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));

        if (productRepository.existsByBrandId(id)) {
            throw new BrandException(ErrorMessage.BRAND_HAS_PRODUCTS, CriticalLevel.NON_CRITICAL);
        }

        brandRepository.delete(brand);
    }
}