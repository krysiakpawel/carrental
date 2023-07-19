package org.rental.booking;

import org.rental.customer.Customer;
import org.rental.customer.Renter;
import org.rental.extrases.Extras;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;

public class BookingService {

    public Booking createNewBooking(Customer renter, Customer driver, Vehicle vehicle){
        return new Booking(renter,driver,vehicle);
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
}