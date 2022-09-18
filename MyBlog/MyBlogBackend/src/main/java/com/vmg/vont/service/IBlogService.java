package com.vmg.vont.service;

import com.vmg.vont.models.dto.BlogDTO;
import com.vmg.vont.form.BlogFormInput;
import com.vmg.vont.models.pojo.Blog;

import java.util.List;

public interface IBlogService {
    BlogDTO save(BlogFormInput blog);
    void delete(long[] ids);
    List<BlogDTO> findAll();
    Blog findById(Long id);
    List<BlogDTO> findByCategory(Long id);
}
