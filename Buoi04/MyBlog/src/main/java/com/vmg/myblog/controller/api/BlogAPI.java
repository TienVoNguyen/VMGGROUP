package com.vmg.myblog.controller.api;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.BlogDTO;
import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.impl.FileManagerService;
import com.vmg.myblog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
public class BlogAPI {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    FileManagerService fileManagerService;

    @PostMapping(value = "create", consumes = { "multipart/form-data" })
    public BlogDTO save(@RequestPart("blog") BlogDTO blog, @RequestPart("file") MultipartFile file) {
        blog.setCover(fileManagerService.save("images", file));
        return blogService.save(blog);
    }

    @PostMapping(value = "update", consumes = { "multipart/form-data" })
    public BlogDTO update( @RequestBody BlogDTO blog , @RequestPart("file") MultipartFile file) {
        blog.setCover(fileManagerService.save("images", file));
        return blogService.save(blog);
    }

    @DeleteMapping("delete")
    public void delete (@RequestBody long[] ids) {
        blogService.delete(ids);
    }
}
