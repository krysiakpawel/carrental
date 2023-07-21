package org.rental.booking;

import org.rental.customer.Customer;
import org.rental.customer.Renter;
import org.rental.extrases.Extras;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;
import org.rental.workshop.WorkshopService;


import org.springframework.stereotype.Service;

@Service
public class BookingService {

    // add try & catch and LOGGER
    // logic for checking that vehicle is not in more than one booking at the time

    public void openBooking(Booking booking){

        if(booking.getBookingWasOpened()){
            System.out.println("LOG: Can not open Booking #" + booking.getBookingNumber() + ". Booking #" + booking.getBookingNumber() + " has been opened already");
        } else {
            booking.setStartingMileage(booking.getVehicle().getMileage());
            booking.setBookingIsRunning(true);
            booking.setBookingWasOpened(true);
            System.out.println("LOG: Booking #" + booking.getBookingNumber() + " has been opened");
        }
    }
    public void closeBooking(Booking booking, int mileage){

        WorkshopService workshopService = new WorkshopService();

        if(booking.getBookingIsClosed()){
            System.out.println("LOG: Can not close Booking #"  + booking.getBookingNumber() + ". Booking #" + booking.getBookingNumber() + " is already closed");
        } else {
            booking.setEndingMileage(Math.max(booking.getStartingMileage(),mileage));
            workshopService.checkIfCarNeedsOil(booking.getVehicle());
            booking.setBookingIsRunning(false);
            booking.setBookingIsClosed(true);
            booking.getVehicle().setMileage(Math.max(booking.getStartingMileage(),mileage));
            System.out.println("LOG: Booking #" + booking.getBookingNumber() + " has been closed. Customer drove " + (booking.getEndingMileage() - booking.getStartingMileage()) + " km.");
        }
    }
    public Booking createNewBooking(Customer renter, Customer driver, Vehicle vehicle) {
        return new Booking(renter, driver, vehicle);
    }


    public void modifyDates(Booking booking) {
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