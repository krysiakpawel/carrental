package com.rental.domain.customer.renter;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface RenterDao extends CrudRepository<Renter, Long> {


    Renter findByPassportNumber(String passport);

    List<Renter> findAllByLastName(String lastname);

    List<Renter> findAll();

}