package org.rental.service;

import org.rental.domain.booking.dao.BookingDao;
import org.rental.domain.booking.Booking;
import org.rental.domain.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public Booking getBookingByBookingNumber(Integer bookingNumber){
        return bookingDao.getBookingByBookingNumber(bookingNumber);
    }

    public void addVehicle(int bookingNumber, String licenseNumber){
        Vehicle vehicle = vehicleService.getVehicleByLicenseNumber(licenseNumber);
        Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
        booking.setVehicle(vehicle);
        bookingDao.save(booking);

    }
}










    /*
    public void openBooking(Booking booking){

        if(booking.getBookingWasOpened()){
            System.out.println("INFO: Can not open Booking #" + booking.getBookingNumber() + ". Booking #" + booking.getBookingNumber() + " has been opened already");
        } else {
            booking.setStartingMileage(booking.getVehicle().getMileage());
            booking.setBookingIsRunning(true);
            booking.setBookingWasOpened(true);
            System.out.println("INFO: Booking #" + booking.getBookingNumber() + " has been opened");
        }
    }
    public void closeBooking(Booking booking, int mileage){
    }
    public Booking createNewBooking(Customer renter, Customer driver) {
        try {
            bookingDao.save(new Booking());
        } catch (Exception e) {
            return null;
        }
    }
    public void addVehicleToBooking(Booking booking, Vehicle vehicle){
        booking.setVehicle(vehicle);
    }
    public void modifyPickUpDate(Booking booking, LocalDate date) {
        booking.setStartingDate(date);
    }
    public void modifyReturnDate(Booking booking, LocalDate date) {
        booking.setReturnDate(date);
    }

    public int countTotalDays(Booking booking){
        LocalDateTime pickUpDateTime = LocalDateTime.of(booking.getStartingDate().getYear(), booking.getStartingDate().getMonth(),
                                                        booking.getStartingDate().getDayOfMonth(), booking.getStartingTime().getHour(), booking.getStartingTime().getMinute(),0);
        LocalDateTime returnDateTime = LocalDateTime.of(booking.getReturnDate().getYear(), booking.getReturnDate().getMonth(),
                                                        booking.getReturnDate().getDayOfMonth(), booking.getReturnTime().getHour(), booking.getReturnTime().getMinute(), 0);
        return IntMath.divide((int) Duration.between(pickUpDateTime, returnDateTime).toHours(), 24, RoundingMode.CEILING );
    }
    public void modifyDriver(Booking booking, Renter customer){
        try {
            booking.setDriver(customer);
        } catch (Exception e){
            System.out.println("LOG: Something went wrong when modifying driver");
        }
    }
    public void modifyRenter(Booking booking, Renter customer){
        try {
            booking.setRenter(customer);
        } catch (Exception e ){
            System.out.println("LOG: Something went wrong when modifying driver");
        }
    }
    */
