package com.vmg.vont;

import com.vmg.vont.dao.ICityDAO;
import com.vmg.vont.model.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    private final ICityDAO cityDAO;

    public MyRunner(ICityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Saving cities");

        cityDAO.save(new City("Bratislava", 432000));
        cityDAO.save(new City("Budapest", 1759000));
        cityDAO.save(new City("Prague", 1280000));
        cityDAO.save(new City("Warsaw", 1748000));
        cityDAO.save(new City("Los Angeles", 3971000));
        cityDAO.save(new City("New York", 8550000));
        cityDAO.save(new City("Edinburgh", 464000));
        cityDAO.save(new City("Suzhou", 4327066));
        cityDAO.save(new City("Zhengzhou", 4122087));
        cityDAO.save(new City("Berlin", 3671000));
    }
}
