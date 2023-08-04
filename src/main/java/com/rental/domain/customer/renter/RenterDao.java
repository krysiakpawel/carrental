package com.rental.domain.customer.renter;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface RenterDao extends CrudRepository <Renter, Long> {
}
