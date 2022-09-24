package com.vmg.vont.dao;

import com.vmg.vont.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityDAO extends JpaRepository<City, Long> {
}
