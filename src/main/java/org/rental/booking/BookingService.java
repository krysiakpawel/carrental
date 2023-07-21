package org.rental.booking;

import org.rental.customer.Customer;
import org.rental.customer.Renter;
import org.rental.extrases.Extras;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;
import org.rental.workshop.WorkshopService;


import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BookingService {

    // add try & catch and LOGGER
    // logic for checking that vehicle is not in more than one booking at the time

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

        WorkshopService workshopService = new WorkshopService();

        if(booking.getBookingIsClosed()){
            System.out.println("INFO: Can not close Booking #"  + booking.getBookingNumber() + ". Booking #" + booking.getBookingNumber() + " is already closed");
        } else {
            booking.setEndingMileage(Math.max(booking.getStartingMileage(),mileage));
            System.out.println(workshopService.checkIfCarNeedsOil(booking.getVehicle()));
            booking.setBookingIsRunning(false);
            booking.setBookingIsClosed(true);
            booking.getVehicle().setMileage(Math.max(booking.getStartingMileage(),mileage));
            System.out.println("INFO: Booking #" + booking.getBookingNumber() + " has been closed. Customer drove " + (booking.getEndingMileage() - booking.getStartingMileage()) + " km.");
        }
    }
    public Booking createNewBooking(Customer renter, Customer driver) {
        return new Booking(renter, driver);
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

    public Duration countTotalDays(Booking booking){


        LocalDateTime pickUpDateTime = LocalDateTime.of(booking.getStartingDate().getYear(), booking.getStartingDate().getMonth(),
                                                        booking.getStartingDate().getDayOfMonth(), 0, 0,0);
        LocalDateTime returnDateTime = LocalDateTime.of(booking.getReturnDate().getYear(), booking.getReturnDate().getMonth(),
                                                        booking.getReturnDate().getDayOfMonth(), 0, 0, 0);

        Duration duration = Duration.between(pickUpDateTime, returnDateTime);

        return duration;





    }

    public void modifyPrice(Booking booking, Price price){
    }

    public void modifyDriver(Booking booking, Renter customer){
    }

    public void modifyRenter(Booking booking, Renter customer){
    }

    public void addExtra(Extras extras){
    }

    public void getNumberOfDays(){}

    public void getBookingPrice(){}
}