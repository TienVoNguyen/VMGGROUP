package com.vmg.vont.service;

import com.vmg.vont.model.City;

import java.util.List;

public interface ICityService {
    City findById(Long id);
    City save(City city);
    List<City> findAll();
}
