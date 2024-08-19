package com.tikim.org.musinsa.domain.category.entity;

import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceCreateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceUpdateRequest;

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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    public static Category from(CategoryServiceCreateRequest request) {
        return Category.builder()
            .name(request.getName())
            .build();
    }

    public void update(CategoryServiceUpdateRequest request) {
        this.name = request.getName();
    }
}
