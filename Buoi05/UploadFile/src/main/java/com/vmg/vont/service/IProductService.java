package com.vmg.vont.service;

import com.vmg.vont.Models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void remove(Long id);
}
