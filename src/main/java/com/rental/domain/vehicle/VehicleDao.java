package com.rental.domain.vehicle;

import com.rental.domain.vehicle.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Transactional
@Repository
public interface VehicleDao extends CrudRepository <Vehicle, Integer> {


    Vehicle getVehicleByLicenseNumber(String licenseNumber);

    ArrayList<Vehicle> getVehicleByModel(String model);
}
