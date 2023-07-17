package org.rental.booking;

import org.rental.customer.Renter;
import org.rental.price.Price;
import org.rental.vehicle.VehicleTemp;

import java.util.Date;

public class Booking {

    private int bookingNumber;
    private Renter renter;
    private Renter driver;
    private VehicleTemp vehicle;
    private Price price;
    private static int bookingCount;

    private Date startingDate;
    private Date endingDate;


    public Booking (){

    }

    public String toString(){
        return "Booking number: " + bookingNumber;





    }












}
