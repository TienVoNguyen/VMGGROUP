package com.vmg.myblog.service.impl;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.repository.IBlogRepository;
import com.vmg.myblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Blog save(Blog blog) {
        blog = blogRepository.save(blog);
        return blog;
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            blogRepository.deleteById(id);
        }
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }


}
