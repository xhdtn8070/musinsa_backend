package com.tikim.org.musinsa.domain.brand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html/brand")
public class BrandHtmlController {

    @GetMapping
    public String brandListPage() {
        return "brand/list";
    }

    @GetMapping("/new")
    public String createBrandPage() {
        return "brand/form";
    }

    @GetMapping("/edit/{id}")
    public String updateBrandPage() {
        return "brand/form";
    }
}
