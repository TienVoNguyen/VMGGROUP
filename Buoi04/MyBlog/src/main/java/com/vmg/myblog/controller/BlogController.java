package com.vmg.myblog.controller;

import com.vmg.myblog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "index";
    }
}
