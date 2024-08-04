package com.tikim.org.musinsa.domain.category.entity;

import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceCreateRequest;
import com.tikim.org.musinsa.domain.category.service.dto.request.CategoryServiceUpdateRequest;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public static Category from(CategoryServiceCreateRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public void update(CategoryServiceUpdateRequest request) {
        this.setName(request.getName());
    }
}
