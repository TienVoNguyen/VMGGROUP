package com.vmg.vont.dao;

import com.vmg.vont.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDAO extends JpaRepository<Company, Integer> {
}
