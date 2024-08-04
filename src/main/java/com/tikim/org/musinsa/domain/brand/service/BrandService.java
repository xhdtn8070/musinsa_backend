package com.tikim.org.musinsa.domain.brand.service;

import com.tikim.org.musinsa.domain.brand.dto.BrandResponse;
import com.tikim.org.musinsa.domain.brand.dto.CreateBrandRequest;
import com.tikim.org.musinsa.domain.brand.dto.UpdateBrandRequest;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.exception.BrandException;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.exception.CategoryException;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<BrandResponse> getAllBrands() {
        return brandRepository.findAll().stream()
            .map(BrandResponse::from)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BrandResponse getBrandById(Long id) {
        return brandRepository.findById(id)
            .map(BrandResponse::from)
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Transactional
    public BrandResponse createBrand(CreateBrandRequest request) {
        Brand brand = Brand.from(request);
        return BrandResponse.from(brandRepository.save(brand));
    }

    @Transactional
    public BrandResponse updateBrand(Long id, UpdateBrandRequest request) {
        Brand existingBrand = brandRepository.findById(id)
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));
        existingBrand.update(request);
        return BrandResponse.from(brandRepository.save(existingBrand));
    }

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
