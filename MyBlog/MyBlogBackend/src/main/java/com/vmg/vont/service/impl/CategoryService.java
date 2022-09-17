package com.vmg.vont.service.impl;

import com.vmg.vont.dao.ICategoryDAO;
import com.vmg.vont.models.pojo.Category;
import com.vmg.vont.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public Category save(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryDAO.deleteById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryDAO.getReferenceById(id);
    }

    @Override
    public Category findOneByCode(String categoryCode) {
        return categoryDAO.findOneByCode(categoryCode);
    }
}
