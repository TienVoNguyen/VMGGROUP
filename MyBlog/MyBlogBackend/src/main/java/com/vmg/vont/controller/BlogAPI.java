package com.vmg.vont.controller;

import com.vmg.vont.models.dto.BlogDTO;
import com.vmg.vont.models.form.BlogForm;
import com.vmg.vont.service.IBlogService;
import com.vmg.vont.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @PostMapping(value = "create")
    public ResponseEntity<?> save(@Valid @ModelAttribute BlogForm blogForm, BindingResult bindingResult) {
        MultipartFile[] files = blogForm.getCover();
        if (Arrays.stream(files).toList().get(0).getSize() <=0) {
            bindingResult.addError(new FieldError("blogForm", "files","File can't not null"));
        }
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(blogService.save(blogForm));
    }
    @PutMapping(value = "update")
    public BlogDTO update(@ModelAttribute BlogForm blogForm) {
        return blogService.save(blogForm);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete (@RequestBody long[] ids) {
        blogService.delete(ids);
        return ResponseEntity.ok("true");
    }
}
