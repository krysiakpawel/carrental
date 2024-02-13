package com.rental.domain.customer.driver;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface DriverDao extends CrudRepository <Driver, Long> {

    Driver findByDrivingLicenseNumber(String drivingLicense);

    List<Driver>findAll();

    List<Driver> findAllByLastName(String lastname);
}
