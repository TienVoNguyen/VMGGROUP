package com.vmg.myblog.controller.api;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.service.impl.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class BlogAPI {
    @Autowired
    BlogService blogService;

    @PostMapping("create")
    public Blog save( @RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @PutMapping("update")
    public Blog update( @RequestBody Blog blog) {
        return blogService.save(blog);
    }

    @DeleteMapping("delete")
    public void delete (@RequestBody long[] ids) {
        System.out.println(ids);
        blogService.delete(ids);
    }
}
