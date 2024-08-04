package com.tikim.org.musinsa.domain.category.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html/category")
@RequiredArgsConstructor
public class CategoryHtmlController {

    @GetMapping
    public String categoryListPage() {
        return "category/list";
    }

    @GetMapping("/new")
    public String createCategoryPage() {
        return "category/form";
    }

    @GetMapping("/edit/{id}")
    public String updateCategoryPage() {
        return "category/form";
    }
}
