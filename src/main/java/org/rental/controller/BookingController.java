package org.rental.controller;

import org.rental.domain.booking.Booking;
import org.rental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping(value = "addBooking")
    public void addBooking(@RequestBody Booking booking){
        bookingService.saveBooking(booking);
    }
}
