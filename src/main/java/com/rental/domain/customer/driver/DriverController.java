package com.rental.domain.customer.driver;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @RequestMapping(method = RequestMethod.POST, value = "addDriver")
    public void addDriver(@RequestParam String name,
                          @RequestParam String lastName,
                          @RequestParam String drivingLicenseNumber,
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate DOB) throws PropertyValueException {
        driverService.addDriver(new Driver(name, lastName, drivingLicenseNumber, DOB));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getDriverByDrivingLicense")
    public Driver getDriverByDrivingLicense(String licenseNumber) throws NullPointerException{
       return driverService.getDriverByDrivingLicense(licenseNumber);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllDrivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }
    @RequestMapping(method = RequestMethod.GET, value = "getDriverByLastName")
    public List<Driver> getDriverByLastName(@RequestParam String lastname) {
        return driverService.getDriversByLastName(lastname);
    }
}
