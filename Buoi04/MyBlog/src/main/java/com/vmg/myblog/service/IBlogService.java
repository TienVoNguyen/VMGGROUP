package com.vmg.myblog.service;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.BlogDTO;
import com.vmg.myblog.model.BlogForm;

import java.util.List;

public interface IBlogService {
    BlogDTO save(BlogForm blog);
    void delete(long[] ids);
    List<BlogDTO> findAll();
    Blog findById(Long id);
    List<BlogDTO> findByCategory(Long id);
}
