package com.vmg.vont.service.impl;

import com.vmg.vont.dao.ICityDAO;
import com.vmg.vont.exception.CityNotFoundException;
import com.vmg.vont.exception.NoDataFoundException;
import com.vmg.vont.model.City;
import com.vmg.vont.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {
    @Autowired
    ICityDAO cityDAO;

    @Override
    public City findById(Long id) {
        return cityDAO.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City save(City city) {
        return cityDAO.save(city);
    }

    @Override
    public List<City> findAll() {
        List<City> cities = (List<City>) cityDAO.findAll();
        if (cities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return cities;
    }
}
