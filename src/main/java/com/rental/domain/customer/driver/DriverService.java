package com.rental.domain.customer.driver;

import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverDao driverDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverService.class);

    public boolean addDriver(Driver driver) throws PropertyValueException {
        try {
            driverDao.save(driver);
            LOGGER.info("ADDED NEW DRIVER. " + driver.getName() + " " + driver.getLastName());
            return true;
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public Driver getDriverByDrivingLicense(String drivingLicense) throws NullPointerException {
        try {
            return driverDao.findByDrivingLicenseNumber(drivingLicense);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public List<Driver> getAllDrivers() {
        return new ArrayList<Driver>(driverDao.findAll());
    }

    public List<Driver> getDriversByLastName(String lastname) {
        return new ArrayList<Driver>(driverDao.findAllByLastName(lastname));
    }
}