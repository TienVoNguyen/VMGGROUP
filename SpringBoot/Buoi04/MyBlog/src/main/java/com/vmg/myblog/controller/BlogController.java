package com.vmg.myblog.controller;

import com.vmg.myblog.model.BlogForm;
import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("index")
    public String index(Model model, @RequestParam("cateId") Optional<Long> id) {
        if(id.isPresent()) {
            model.addAttribute("blogs", blogService.findByCategory(id.get()));
        }else{
            model.addAttribute("blogs", blogService.findAll());
        }
        model.addAttribute("categories", categoryService.findAll());
        BlogForm blog = new BlogForm();
        model.addAttribute("blog1", blog);
        return "index";
    }

//    @PostMapping("index/validate")
//    public String validated(Model model, @Validated @ModelAttribute("blog1") BlogForm blogForm, Errors errors) {
//        System.out.println(blogForm);
//        if(errors.hasErrors()) {
//            System.out.println("Errors: \n"+errors.getAllErrors());
//            model.addAttribute("message", "sua loi de");
//        }
//        return "index";
//    }

}
