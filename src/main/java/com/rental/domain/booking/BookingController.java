package com.rental.domain.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PutMapping(value = "addBooking")
    public void addBooking(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
    }

    /*
    @PutMapping(value = "addVehicle")
    public void addVehicleToBooking(@RequestParam int bookingNumber, String licenseNumber) throws Exception {
        bookingService.addVehicleToBooking(bookingNumber, licenseNumber);
    }



    @PutMapping(value = "openBooking")
    public void openBooking(@RequestParam int bookingNumber) throws Exception {
        bookingService.openBooking(bookingNumber);
    }

    */

    @PutMapping(value = "closeBooking")
    public void closeBooking(@RequestParam int bookingNumber, int mileage) throws Exception {
        bookingService.closeBooking(bookingNumber, mileage);
    }

    @DeleteMapping(value = "deleteBooking")
    public void deleteBooking(@RequestParam int bookingNumber) {


    }
}
