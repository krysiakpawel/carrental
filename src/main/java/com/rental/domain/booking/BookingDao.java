package com.rental.domain.booking;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;

@Transactional
@Repository
public interface BookingDao extends CrudRepository<Booking, Long> {

    Booking getBookingByBookingNumber(int bookingNumber);

    ArrayList<Booking> findAll();

    ArrayList<Booking> findAllByStartingDate(LocalDate startingDate);

    ArrayList<Booking> findAllByReturnDate(LocalDate endingDate);

    ArrayList<Booking> findBookingsByVehicleLicenseNumber(String licenseNumber);

}
