package com.vmg.vont.service;

import com.vmg.vont.models.pojo.Category;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    void delete(Long id);
    List<Category> findAll();
    Category findById(Long id);
    Category findOneByCode(String categoryCode);
}
