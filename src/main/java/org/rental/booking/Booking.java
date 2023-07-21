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
    private boolean bookingWasOpened;
    private boolean bookingIsClosed;
    private boolean bookingIsRunning;
    private int startingMileage;
    private int endingMileage;
    private Long id;

    public Booking (Customer renter, Customer driver, Vehicle vehicle) {
        this.renter = renter;
        this.driver = driver;
        this.vehicle = vehicle;
        this.bookingNumber = ++bookingCount;
        this.bookingWasOpened = false;
        this.bookingIsClosed = false;
        this.bookingIsRunning = false;
        this.startingMileage = 0;
        this.endingMileage = 0;
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
    public boolean getBookingWasOpened(){
        return bookingWasOpened;
    }
    public void setBookingWasOpened(boolean wasOpened){
        this.bookingWasOpened = wasOpened;
    }
    public boolean getBookingIsClosed(){
        return bookingIsClosed;
    }
    public void setBookingIsClosed(boolean bookingIsClosed){
        this.bookingIsClosed = bookingIsClosed;
    }
    public boolean getBookingIsRunning(){
        return bookingIsRunning;
    }
    public void setBookingIsRunning(boolean bookingIsRunning){
        this.bookingIsRunning = bookingIsRunning;
    }
    public int getStartingMileage(){
        return startingMileage;
    }
     public void setStartingMileage(int startingMileage){
        this.startingMileage = startingMileage;
     }
     public int getEndingMileage(){
        return endingMileage;
     }
     public void setEndingMileage(int endingMileage){
        this.endingMileage = endingMileage;
     }

    public String toString(){
        return "Booking number #" + bookingNumber + "\n" +
                "Renter: " + renter.getFirstName() + " " + renter.getLastName() + "\n" +
                "Driver: " + driver.getFirstName() + " " + driver.getLastName() + "\n" +
                "Vehicle: " + vehicle.getModel() + " " + vehicle.getMake() + " " + vehicle.getLicenseNumber();
                // + "Price for booking " + price.getAmount() + " " + price.getCurrency();
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
