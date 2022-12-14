package com.vmg.vont.controller;

import com.vmg.vont.Models.Product;
import com.vmg.vont.Models.ProductForm;
import com.vmg.vont.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    @Value("${upload.path}")
    private String fileUpload;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/product/list");
        List<Product> products = (List<Product>) productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.addObject("message", "Thanh cong");
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new ProductForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView createProduct(@ModelAttribute ProductForm product){
        Product product1 = new Product.ProductBuilder(product.getName())
                .description(product.getDescription()).build();
        MultipartFile multipartFile = product.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(product.getImage().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product1.setImage(fileName);
        productService.save(product1);
        return new RedirectView("");
    }
}
