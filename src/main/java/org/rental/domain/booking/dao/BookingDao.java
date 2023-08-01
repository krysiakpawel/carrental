package org.rental.domain.booking.dao;

import jakarta.transaction.Transactional;
import org.rental.domain.booking.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface BookingDao extends CrudRepository <Booking, Long> {

    Booking getBookingByBookingNumber(int bookingNumber);

    Booking getBookingById(Long id);
}
