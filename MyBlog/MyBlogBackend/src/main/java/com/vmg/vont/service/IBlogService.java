package com.vmg.vont.service;

import com.vmg.vont.payload.response.BlogResponse;
import com.vmg.vont.models.dto.BlogDTO;
import com.vmg.vont.payload.request.BlogRequest;
import com.vmg.vont.models.pojo.Blog;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    BlogDTO save(BlogRequest blog);
    void delete(long[] ids);
    List<BlogDTO> findAll();
    Blog findById(Long id);
    List<BlogDTO> findByCategory(Long id);

    BlogResponse findAll(Pageable pageable);
}
