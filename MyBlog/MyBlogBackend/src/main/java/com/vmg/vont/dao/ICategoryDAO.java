package com.vmg.vont.dao;

import com.vmg.vont.models.pojo.Blog;
import com.vmg.vont.models.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryDAO extends JpaRepository<Category, Long> {
    Category findOneByCode(String categoryCode);
}
