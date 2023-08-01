package org.rental.controller;

import org.rental.domain.booking.Booking;
import org.rental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping(value = "addBooking")
    public void addBooking(@RequestBody Booking booking){
        bookingService.saveBooking(booking);
    }

    @PutMapping(value = "addVehicle")
    public void addVehicle(@RequestParam int bookingNumber, String licenseNumber) {
        bookingService.addVehicle(bookingNumber, licenseNumber);
    }

    @PutMapping(value = "openBooking")
    public void openBooking(@RequestParam int bookingNumber, int mileage) {
        Booking booking = bookingService.getBookingByBookingNumber(bookingNumber);
        booking.setBookingWasOpened(true);
        booking.setBookingIsRunning(true);
        booking.setStartingMileage(mileage);
        bookingService.saveBooking(booking);
    }

    @PutMapping(value = "closeBooking")
    public void closeBooking(@RequestParam int bookingNumber, int mileage){
        Booking booking = bookingService.getBookingByBookingNumber(bookingNumber);
        booking.setBookingIsClosed(true);
        booking.setBookingIsRunning(false);
        booking.setEndingMileage(mileage);
        booking.getVehicle().setMileage(mileage);
        bookingService.saveBooking(booking);
    }





    @DeleteMapping(value = "deleteBooking")
    public void deleteBooking(@RequestParam int bookingNumber){




    }
}
