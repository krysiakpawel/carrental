package org.rental.domain.vehicle.dao;

import jakarta.transaction.Transactional;
import org.rental.domain.vehicle.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface VehicleDao extends CrudRepository <Vehicle, Integer> {


    Vehicle getVehicleByLicenseNumber(String licenseNumber);
}
