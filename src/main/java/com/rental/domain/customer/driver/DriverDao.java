package com.rental.domain.customer.driver;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface DriverDao extends CrudRepository <Driver, Long> {
}
