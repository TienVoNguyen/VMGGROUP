package com.vmg.vont.controller;

import com.vmg.vont.models.dto.BlogDTO;
import com.vmg.vont.form.BlogFormInput;
import com.vmg.vont.service.IBlogService;
import com.vmg.vont.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Arrays;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogAPI {
    private final IBlogService blogService;
    private final ICategoryService categoryService;

    public BlogAPI(IBlogService blogService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> save(@Valid @ModelAttribute BlogFormInput blogFormInput, BindingResult bindingResult) {
        MultipartFile[] files = blogFormInput.getCover();
        if (Arrays.stream(files).toList().get(0).getSize() <=0) {
            bindingResult.addError(new FieldError("blogForm", "files","File can't not null"));
        }
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(blogService.save(blogFormInput));
    }
    @PutMapping(value = "update/{id}")
    public BlogDTO update(@ModelAttribute BlogFormInput blogFormInput, @PathVariable Long id) {
        blogFormInput.setId(id);
        return blogService.save(blogFormInput);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete (@RequestBody long[] ids) {
        blogService.delete(ids);
        return ResponseEntity.ok("true");
    }
}
