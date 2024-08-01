package com.tikim.org.musinsa.domain.category.service;

import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
