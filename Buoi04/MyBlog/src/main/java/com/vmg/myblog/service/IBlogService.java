package com.vmg.myblog.service;

import com.vmg.myblog.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog save(Blog blog);
    void delete(long[] ids);
    void delete(Long id);

    List<Blog> findAll();
}
