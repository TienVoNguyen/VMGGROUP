package com.vmg.myblog.controller.api;

import com.vmg.myblog.model.BlogDTO;
import com.vmg.myblog.model.BlogForm;
import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogAPI {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @PostMapping(value = "create")
    public ResponseEntity<?> save( @Validated @ModelAttribute BlogForm blogForm, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.ok(errors.getAllErrors());
        }
        return ResponseEntity.ok(blogService.save(blogForm));
    }
    @PutMapping(value = "update")
    public BlogDTO update( @ModelAttribute BlogForm blogForm) {
        return blogService.save(blogForm);
    }

    @DeleteMapping("delete")
    public ResponseEntity delete (@RequestBody long[] ids) {
        blogService.delete(ids);
        return ResponseEntity.ok("true");
    }
}
