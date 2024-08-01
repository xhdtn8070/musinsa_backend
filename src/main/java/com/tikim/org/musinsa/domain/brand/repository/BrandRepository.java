package com.tikim.org.musinsa.domain.brand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tikim.org.musinsa.domain.brand.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
