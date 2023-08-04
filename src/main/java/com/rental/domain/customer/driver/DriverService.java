package com.rental.domain.customer.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverDao driverDao;

    public Driver addDriver(Driver driver) throws Exception {
        if (driver == null) {
            throw new Exception("Renter is NULL");
        } else {
            return driverDao.save(driver);
        }
    }
}
