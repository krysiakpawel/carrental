package org.rental.booking;

import org.rental.customer.Customer;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;

import java.util.Date;

public class Booking {

    private int bookingNumber;
    private Customer customer;
    private Vehicle vehicle;
    private Price price;
    private static int bookingCount;

    private Date startingDate;
    private Date endingDate;












    public Booking (Customer customer, Vehicle vehicle, Price price){
        this.customer = customer;
        this.vehicle = vehicle;
        this.price = price;
        this.bookingNumber = ++bookingCount;

    }

    public String getCustomerName(){
        return customer.getName();
    }
    public String getCustomerLastname(){
        return customer.getLastname();
    }
    public String getVehicleModel(){
        return vehicle.getModel();
    }
    public String getVehicleMake(){
        return vehicle.getMake();
    }
    public int getBookingNumber(){
        return bookingNumber;
    }

    public String toString(){
        return "Booking number: #" + bookingNumber + "\n"
                + "Customer: " + customer.getName() + " " + customer.getLastname() + "\n"
                + "Vehicle: " +  vehicle.getModel() + " " + vehicle.getMake() + " " + vehicle.getLicenseNumber() + "\n"
                + "Price: " + price.getAmmount() + " " + price.getCurrency();







    }












}
