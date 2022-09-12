package com.vmg.myblog.repository;

import com.vmg.myblog.model.Blog;
import com.vmg.myblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
