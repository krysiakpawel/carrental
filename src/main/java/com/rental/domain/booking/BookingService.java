package com.rental.domain.booking;

import com.rental.domain.vehicle.Vehicle;
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

    public Booking getBookingByBookingNumber(int bookingNumber) {
        return bookingDao.getBookingByBookingNumber(bookingNumber);
    }

    public void cancelBooking(int bookingNumber) {
        Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
        booking.setBookingStatus(0);
        bookingDao.save(booking);
        System.out.println("LOG: BOOKING " + booking.getBookingNumber() + " CANCELLED;");
    }

    public void openBooking(int bookingNumber) throws Exception {
        Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
        if (booking == null) {
            throw new Exception("LOG: BOOKING " + bookingNumber + " NOT FOUND;");
        } else {
            if (booking.getBookingStatus() == 1) {
                booking.setBookingStatus(2);
                booking.setStartingMileage(booking.getVehicle().getMileage());
                bookingDao.save(booking);
                System.out.println("LOG: BOOKING " + booking.getBookingNumber() + " OPENED;");
            } else {
                // dodac logike do rozrozniana czy booking jest obecnie otwarty (w jakim stanie jest booking)
                System.out.println("Can not start booking.");
            }
        }
    }
        public void closeBooking ( int bookingNumber, int endingMileage) throws Exception {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            Vehicle vehicle = booking.getVehicle();
            if (booking == null) {
                throw new Exception("LOG: BOOKING " + bookingNumber + " NOT FOUND;");
            } else if (booking.getBookingStatus() != 2) {
                throw new Exception("LOG: BOOKING " + bookingNumber + " IS NOT OPEN;");
            } else {
                if (vehicle.getMileage() <= endingMileage){
                    vehicle.setMileage(endingMileage);
                    booking.setBookingStatus(3);
                    booking.setEndingMileage(endingMileage);
                    System.out.println("LOG: VEHICLE MILEAGE SET TO: " + endingMileage);
                    System.out.println("LOG: BOOKING " + bookingNumber + " CLOSED;");
                    bookingDao.save(booking);
                } else {
                    System.out.println("LOG: VEHICLE MILEAGE CAN'T BE LOWER");
                }
            }
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

    public void addDriverToBooking(int bookingNumber, Driver driver) throws Exception {
        if (bookingDao.getBookingByBookingNumber(bookingNumber) == null || driver == null) {
            throw new Exception("Error adding driver. Either driver or booking is null");
        } else {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            booking.setDriver(new Driver(driver.getName(),driver.getLastName(),driver.getDrivingLicenseNumber(), driver.getDOB()));







        }
    }





*/

        public void createNewBooking () throws Exception {
        }

        public void modifyPickUpDate (Booking booking, LocalDate date){
            booking.setStartingDate(date);
        }

        public void modifyReturnDate (Booking booking, LocalDate date){
            booking.setReturnDate(date);
        }

        public void countTotalDays () {
        }

        public void modifyDriver () {
        }

        public void modifyRenter () {
        }
    }

