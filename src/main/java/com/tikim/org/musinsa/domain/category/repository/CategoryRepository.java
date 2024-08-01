package com.tikim.org.musinsa.domain.category.repository;

import com.tikim.org.musinsa.domain.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
