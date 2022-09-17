package com.vmg.vont.service.impl;

import com.vmg.vont.dao.IBlogDAO;
import com.vmg.vont.dao.ICategoryDAO;
import com.vmg.vont.dao.ICoverBlogDAO;
import com.vmg.vont.models.dto.BlogDTO;
import com.vmg.vont.models.form.BlogForm;
import com.vmg.vont.models.pojo.Blog;
import com.vmg.vont.models.pojo.Category;
import com.vmg.vont.models.pojo.CoverBlog;
import com.vmg.vont.service.IBlogService;
import com.vmg.vont.service.ICategoryService;
import com.vmg.vont.service.ICoverBlogService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogDAO blogDAO;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    FileManagerService fileManagerService;
    @Autowired
    ICoverBlogService coverBlogService;

    @Override
    public BlogDTO save(BlogForm blogForm) {
        BlogDTO blogDTO = modelMapper.map(blogForm, BlogDTO.class);
        List<String> filenames = fileManagerService.save("images", blogForm.getCover());
        Blog blog = convertToModel(blogDTO);
        blog = blogDAO.save(blog);
        for (String filename:filenames) {
            coverBlogService.save(filename, blog);
        }
        return convertToDTO(blog);
    }

    @Override
    public void delete(long[] ids) {
        for (long id:ids) {
//            fileManagerService.delete("images", String.valueOf(this.findById(id).getCover()));
            Blog blog = blogDAO.getReferenceById(id);
            for (CoverBlog coverBlog:blog.getCoverBlogs()) {
                fileManagerService.delete("images", coverBlog.getCoverName());
                coverBlogService.delete(coverBlog);
            }
            blogDAO.deleteById(id);
        }
    }

    @Override
    public List<BlogDTO> findAll() {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        List<Blog> blogList = blogDAO.findAll();
        for(Blog blog: blogList) {
            BlogDTO blogDTO = convertToDTO(blog);
            List<String> images = new ArrayList<>();
            for (CoverBlog coverBlog: blog.getCoverBlogs()) {
                images.add(coverBlog.getCoverName());
            }
            blogDTO.setCoverNameList(images);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }

    @Override
    public Blog findById(Long id) {
        return blogDAO.getReferenceById(id);
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO blogDTO = modelMapper.map(blog, BlogDTO.class);

        blogDTO.setCategoryCode(blog.getCategory().getCode());
        return blogDTO;
    }

    private Blog convertToModel(BlogDTO blogDTO) {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        if (blogDTO.getId() != null) {
            Blog oldBlog = blogDAO.getReferenceById(blogDTO.getId());
            for(CoverBlog coverBlog: oldBlog.getCoverBlogs()) {
                fileManagerService.delete("images", coverBlog.getCoverName());
            }
            blog.setId(oldBlog.getId());
        }
        Category category = categoryService.findOneByCode(blogDTO.getCategoryCode());
        blog.setCategory(category);
        return blog;
    }

    @Override
    public List<BlogDTO> findByCategory(Long id) {
        List<BlogDTO> blogDTOList = new ArrayList<>();
        List<Blog> blogList = blogDAO.findByCategoryId(id);
        for(Blog blog: blogList) {
            BlogDTO blogDTO = convertToDTO(blog);
            List<String> images = new ArrayList<>();
            for (CoverBlog coverBlog: blog.getCoverBlogs()) {
                images.add(coverBlog.getCoverName());
            }
            blogDTO.setCoverNameList(images);
            blogDTOList.add(blogDTO);
        }
        return blogDTOList;
    }
}
