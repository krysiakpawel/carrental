package org.rental.service;

import org.rental.domain.vehicle.Vehicle;
import org.rental.domain.vehicle.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    public Vehicle saveVehicle(Vehicle vehicle){
        if (vehicle != null){
            return vehicleDao.save(vehicle);
        }
        return new Vehicle();

    }
}
