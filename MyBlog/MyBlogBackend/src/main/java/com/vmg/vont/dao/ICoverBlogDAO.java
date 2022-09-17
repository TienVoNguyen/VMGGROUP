package com.vmg.vont.dao;

import com.vmg.vont.models.pojo.CoverBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoverBlogDAO extends JpaRepository<CoverBlog, Long> {
}