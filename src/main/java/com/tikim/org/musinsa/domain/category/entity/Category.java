package com.tikim.org.musinsa.domain.category.entity;

import com.tikim.org.musinsa.domain.category.dto.CreateCategoryRequest;
import com.tikim.org.musinsa.domain.category.dto.UpdateCategoryRequest;
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

    public static Category from(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public void update(UpdateCategoryRequest request) {
        this.setName(request.getName());
    }
}
