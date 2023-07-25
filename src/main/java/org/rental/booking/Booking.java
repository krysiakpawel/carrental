package org.rental.booking;

import org.rental.customer.Customer;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private static int bookingCount;
    private final int bookingNumber;
    private Customer renter;
    private Customer driver;
    private Customer extraDriver;
    private Vehicle vehicle;
    private Price price;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDate returnDate;
    private LocalTime returnTime;

    //private LocalDate openingDate;
    private boolean bookingWasOpened;
    private boolean bookingIsClosed;
    private boolean bookingIsRunning;
    private int startingMileage;
    private int endingMileage;
    private Long id;

    public Booking (Customer renter, Customer driver) {
        this.renter = renter;
        this.driver = driver;
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
        if(driver != null) {
            this.renter = renter;
        } else {
            System.out.println("Please choose a renter");
        }
    }
    public Customer getDriver (){
        return driver;
    }
    public void setDriver(Customer driver){
        if(driver != null) {
            this.driver = driver;
        } else {
            System.out.println("Please choose a driver");
        }
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
    public LocalDate getStartingDate(){
        return startingDate;
    }
    public void setStartingDate(LocalDate startingDate){
        this.startingDate = startingDate;
    }
    public LocalTime getStartingTime(){
        return startingTime;
    }
    public void setStartingTime(LocalTime time){
        this.startingTime =  time;
    }
    public LocalTime getReturnTime(){
        return returnTime;
    }

    public void setReturnTime(LocalTime time){
        this.returnTime = time;
    }
    public LocalDate getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate){
        this.returnDate = returnDate;
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
        return "Booking #" + bookingNumber + "\n" +
                "Renter: " + getRenter() + "\n" +
                "Driver: " + getDriver() + "\n" +
                "Vehicle: " + getVehicle() + "\n" +
                "Pick-up date: " + getStartingDate() + " at " + getStartingTime() + "\n" +
                "Return date: " + getReturnDate() + " at " + getReturnTime();

    }
}
