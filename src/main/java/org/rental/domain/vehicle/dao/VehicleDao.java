package org.rental.domain.vehicle.dao;

import org.rental.domain.vehicle.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleDao extends CrudRepository <Vehicle, Integer> {
}
