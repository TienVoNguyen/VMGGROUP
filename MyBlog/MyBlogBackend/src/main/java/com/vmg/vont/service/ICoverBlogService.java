package com.vmg.vont.service;

import com.vmg.vont.models.pojo.Blog;
import com.vmg.vont.models.pojo.CoverBlog;

import java.util.List;
import java.util.Optional;

public interface ICoverBlogService {
    CoverBlog save(String filename, Blog blog);
    void delete(Long id);
    List<CoverBlog> findAll();
    Optional<CoverBlog> findById(Long id);

    void delete(CoverBlog coverBlog);
}
