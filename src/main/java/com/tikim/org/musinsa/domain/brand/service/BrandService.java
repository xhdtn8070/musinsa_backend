package com.tikim.org.musinsa.domain.brand.service;

import com.tikim.org.musinsa.domain.brand.dto.CreateBrandRequest;
import com.tikim.org.musinsa.domain.brand.dto.UpdateBrandRequest;
import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.exception.BrandException;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.global.exception.enums.CriticalLevel;
import com.tikim.org.musinsa.global.exception.enums.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;

    @Transactional(readOnly = true)
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
            .orElseThrow(() -> new BrandException(ErrorMessage.BRAND_NOT_EXIST, CriticalLevel.NON_CRITICAL));
    }

    @Transactional
    public Brand createBrand(CreateBrandRequest request) {
        Brand brand = Brand.from(request);
        return brandRepository.save(brand);
    }

    @Transactional
    public Brand updateBrand(Long id, UpdateBrandRequest request) {
        Brand existingBrand = getBrandById(id);
        existingBrand.update(request);
        return brandRepository.save(existingBrand);
    }

    @Transactional
    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);
    }
}
