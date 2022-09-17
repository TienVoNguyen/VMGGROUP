package com.vmg.vont.service;

import com.vmg.vont.models.dto.BlogDTO;
import com.vmg.vont.models.form.BlogForm;
import com.vmg.vont.models.pojo.Blog;

import java.util.List;

public interface IBlogService {
    BlogDTO save(BlogForm blog);
    void delete(long[] ids);
    List<BlogDTO> findAll();
    Blog findById(Long id);
    List<BlogDTO> findByCategory(Long id);
}
