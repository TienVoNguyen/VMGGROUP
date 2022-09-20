package com.vmg.vont.dao;

import com.vmg.vont.models.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogDAO extends JpaRepository<Blog, Long> {
    List<Blog> findByCategoryId(Long id);
    Page<Blog> findAll(Pageable pageable);
}
