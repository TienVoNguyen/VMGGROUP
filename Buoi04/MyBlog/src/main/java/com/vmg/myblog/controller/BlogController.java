package com.vmg.myblog.controller;

import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "index";
    }
}
