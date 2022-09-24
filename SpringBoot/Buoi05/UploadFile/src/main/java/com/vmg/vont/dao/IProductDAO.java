package com.vmg.vont.dao;

import com.vmg.vont.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDAO extends JpaRepository<Product, Long> {
}
