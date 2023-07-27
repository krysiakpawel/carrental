package org.rental.domain.booking.dao;

import org.rental.domain.booking.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingDao extends CrudRepository <Booking, Integer> {
}
