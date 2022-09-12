package com.vmg.myblog.service;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.BlogDTO;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    BlogDTO save(BlogDTO blog);
    void delete(long[] ids);
    List<BlogDTO> findAll();
    Blog findById(Long id);
}
