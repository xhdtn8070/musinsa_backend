package com.tikim.org.musinsa.domain.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/html")
public class MainHtmlController {

    @GetMapping("/index")
    public String mainPage() {
        return "index/index";
    }
}
