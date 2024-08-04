package com.tikim.org.musinsa.domain.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html/product")
public class ProductHtmlController {

    @GetMapping
    public String productListPage() {
        return "product/list";
    }

    @GetMapping("/new")
    public String createProductPage() {
        return "product/form";
    }

    @GetMapping("/edit/{id}")
    public String updateProductPage() {
        return "product/form";
    }
}
