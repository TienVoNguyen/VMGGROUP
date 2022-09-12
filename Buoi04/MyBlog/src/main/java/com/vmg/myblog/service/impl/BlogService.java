package com.vmg.myblog.service.impl;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.BlogDTO;
import com.vmg.myblog.model.Category;
import com.vmg.myblog.repository.IBlogRepository;
import com.vmg.myblog.service.IBlogService;
import com.vmg.myblog.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    FileManagerService fileManagerService;

    @Override
    public BlogDTO save(BlogDTO blogDTO) {
        Blog blog = convertToModel(blogDTO);
        blog = blogRepository.save(blog);
        return convertToDTO(blog);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
            fileManagerService.delete("images", String.valueOf(this.findById(id).getCover()));
            blogRepository.deleteById(id);
        }
    }

    @Override
    public List<BlogDTO> findAll() {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        List<Blog> blogList = blogRepository.findAll();
        for(Blog blog: blogList) {
            blogDTOList.add((convertToDTO(blog)));
        }
        return blogDTOList;
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.getReferenceById(id);
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO blogDTO = modelMapper.map(blog, BlogDTO.class);

        blogDTO.setCategoryId(blog.getCategory().getId());
        return blogDTO;
    }

    private Blog convertToModel(BlogDTO blogDTO) {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        if (blogDTO.getId() != null) {
            Blog oldBlog = blogRepository.getReferenceById(blogDTO.getId());
            fileManagerService.delete("images", oldBlog.getCover());
            blog.setId(oldBlog.getId());
        }
        Category category = categoryService.findById(blogDTO.getCategoryId());
        blog.setCategory(category);
        return blog;
    }
}
