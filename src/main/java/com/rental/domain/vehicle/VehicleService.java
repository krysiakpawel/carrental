package com.rental.domain.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    public Vehicle addVehicle(Vehicle Vehicle) throws Exception {
        if (Vehicle == null) {
            throw new Exception("EXCEPTION: There is no vehicle to save.");
        } else {
            return vehicleDao.save(Vehicle);
        }
    }
     public Vehicle getVehicleByLicenseNumber(String licenseNumber) throws Exception {
         if (vehicleDao.getVehicleByLicenseNumber(licenseNumber) == null) {
             throw new Exception("EXCEPTION: Wrong license number");
         } else {
             return vehicleDao.getVehicleByLicenseNumber(licenseNumber);
         }
     }


}
