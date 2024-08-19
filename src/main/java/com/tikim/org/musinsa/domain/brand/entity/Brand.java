package com.tikim.org.musinsa.domain.brand.entity;

import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceCreateRequest;
import com.tikim.org.musinsa.domain.brand.service.dto.request.BrandServiceUpdateRequest;

import com.tikim.org.musinsa.domain.product.entity.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<Product> products;

    public static Brand from(BrandServiceCreateRequest request) {
        return Brand.builder()
            .name(request.getName())
            .build();
    }

    public void update(BrandServiceUpdateRequest request) {
        this.name = request.getName();
    }
}
