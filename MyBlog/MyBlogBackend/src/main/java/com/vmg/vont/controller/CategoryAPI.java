package com.vmg.vont.controller;

import com.vmg.vont.models.pojo.Category;
import com.vmg.vont.payload.response.BlogResponse;
import com.vmg.vont.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/category")
public class CategoryAPI {
    private final ICategoryService categoryService;

    public CategoryAPI(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<Category>> getAll()
    {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
