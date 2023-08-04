package com.rental.domain.booking;

import com.rental.domain.customer.driver.Driver;
import com.rental.domain.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private VehicleService vehicleService;

    public Booking saveBooking(Booking booking) {
        if (booking != null) {
            return bookingDao.save(booking);
        } else {
            return new Booking();
        }
    }

    public Booking getBookingByBookingNumber(Integer bookingNumber) {
        return bookingDao.getBookingByBookingNumber(bookingNumber);
    }

    /*
       public void addVehicleToBooking(int bookingNumber, String licenseNumber) throws Exception {
           if (bookingDao.getBookingByBookingNumber(bookingNumber) == null || vehicleService.getVehicleByLicenseNumber(licenseNumber) == null) {
               throw new Exception("Error adding vehicle. Either vehicle or booking is null");
           } else {
               Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
               booking.setVehicle(vehicleService.getVehicleByLicenseNumber(licenseNumber));
               bookingDao.save(booking);
           }
       }
    */
    public void addDriver(int bookingNumber, Driver driver) throws Exception {
        if (bookingDao.getBookingByBookingNumber(bookingNumber) == null || driver == null) {
            throw new Exception("Error adding driver. Either driver or booking is null");
        } else {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
        /*


        add logic

        */


        }
    }

    /*
    public void openBooking(int bookingNumber) throws Exception {
        Booking booking = getBookingByBookingNumber(bookingNumber);
        if (booking == null) {
            throw new Exception("ERROR: Cannot find booking with booking number " + bookingNumber);
        } else {
            if (booking.getBookingWasOpened()) {
                System.out.println("INFO: Can not open Booking #" + booking.getBookingNumber() + ". Booking #" + booking.getBookingNumber() + " has been opened already.");
            } else {
                booking.setStartingMileage(booking.getVehicle().getMileage());
                booking.setBookingIsRunning(true);
                booking.setBookingWasOpened(true);
                System.out.println("INFO: Booking #" + booking.getBookingNumber() + " has been opened");
            }
        }
    }

     */

    public void closeBooking(int bookingNumber, int mileage) throws Exception {
        Booking booking = getBookingByBookingNumber(bookingNumber);
        if (booking == null) {
            throw new Exception("Can not find booking " + bookingNumber);
        } else {
            booking.setBookingIsClosed(true);
            booking.setBookingIsRunning(false);
            System.out.println("INFO: Booking #" + booking.getBookingNumber() + " has been closed");
            // add oil check and km for booking logic
        }
    }


    public void createNewBooking() throws Exception {
    }

    public void modifyPickUpDate(Booking booking, LocalDate date) {
        booking.setStartingDate(date);
    }

    public void modifyReturnDate(Booking booking, LocalDate date) {
        booking.setReturnDate(date);
    }

    public void countTotalDays() {
    }

    public void modifyDriver() {
    }

    public void modifyRenter() {
    }
}

