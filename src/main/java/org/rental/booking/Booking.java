package org.rental.booking;

import org.rental.customer.Customer;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;
import java.util.Date;

public class Booking {

    private static int bookingCount;
    private final int bookingNumber;
    private Customer renter;
    private Customer driver;
    private Customer extraDriver;
    private Vehicle vehicle;
    private Price price;
    private Date startingDate;
    private Date endingDate;

    public Booking (Customer renter, Customer driver, Vehicle vehicle) {
        this.renter = renter;
        this.driver = driver;
        this.vehicle = vehicle;
        this.bookingNumber = ++bookingCount;
    }

    public int getBookingNumber(){
        return bookingNumber;
    }
    public Customer getRenter(){
        return renter;
    }
    public void setRenter(Customer renter){
        this.renter = renter;
    }
    public Customer getDriver (){
        return driver;
    }
    public void setDriver(Customer driver){
        this.driver = driver;
    }
    public Customer getExtraDriver(){
        return extraDriver;
    }
    public void setExtraDriver(Customer extraDriver){
        this.extraDriver = extraDriver;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    public Price getPrice(){
        return price;
    }
    public void setPrice(Price price){
        this.price = price;
    }
    public Date getStartingDate(){
        return startingDate;
    }
    public void setStartingDate(Date startingDate){
        this.startingDate = startingDate;
    }
    public Date getEndingDate(){
        return endingDate;
    }
    public void setEndingDate(Date endingDate){
        this.endingDate = endingDate;
    }



    public String toString(){
        return "Booking number: " + bookingNumber + "\n" +
                "Renter: " + renter.getFirstName() + " " + renter.getLastName() + "\n" +
                "Driver: " + driver.getFirstName() + " " + driver.getLastName() + "\n" +
                "Vehicle: " + vehicle.getModel() + " " + vehicle.getMake() + " " + vehicle.getLicenseNumber();
                // + "Price for booking " + price.getAmmount() + " " + price.getCurrency();
    }


}
