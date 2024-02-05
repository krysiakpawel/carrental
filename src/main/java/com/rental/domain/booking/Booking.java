package com.rental.domain.booking;

import com.rental.domain.customer.Customer;
import com.rental.domain.customer.driver.Driver;
import com.rental.domain.customer.renter.Renter;
import com.rental.domain.price.Price;
import com.rental.domain.vehicle.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "BOOKINGS")
public class Booking {

    private static int bookingCount;
    private int bookingNumber;
    private int id;
    private Vehicle vehicle;
    private Renter renter;
    private Driver driver;
    private Price price;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private int bookingStatus;
    private int startingMileage;
    private int endingMileage;

    public Booking(LocalDate startingDate, LocalTime startingTime, LocalDate returnDate, LocalTime returnTime) {
        this.startingDate = startingDate;
        this.startingTime = startingTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.bookingNumber = bookingCount++;
        this.bookingStatus = 1;
        this.startingMileage = 0;
        this.endingMileage = 0;
    }

    public Booking() {
        this.bookingNumber = bookingCount++;
        this.bookingStatus = 1;
        this.startingMileage = 0;
        this.endingMileage = 0;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "RENTER", referencedColumnName = "ID")
    public Renter getRenter(){
        return renter;
    }
    public void setRenter(Renter renter){
        this.renter = renter;
    }

    @ManyToOne
    @JoinColumn(name = "DRIVER", referencedColumnName = "ID")
    public Driver getDriver(){
        return driver;
    }

    public void setDriver(Driver driver){
        this.driver = driver;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "VEHICLE" , referencedColumnName = "ID")
    public Vehicle getVehicle(){
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }


    @Column(name = "BOOKING_NUMBER")
    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Column(name = "STARTING_DATE")
    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    @Column(name = "STARTING_TIME")
    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime time) {
        this.startingTime = time;
    }

    @Column(name = "RETURN_DATE")
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Column(name = "RETURN_TIME")
    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime time) {
        this.returnTime = time;
    }

    @Column(name = "STATUS")
    public int getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(int status) {
        this.bookingStatus = status;
    }
    @Column(name = "STARTING_ODO")
    public int getStartingMileage() {
        return startingMileage;
    }
    public void setStartingMileage(int startingMileage) {
        this.startingMileage = startingMileage;
    }
    @Column(name = "ENDING_ODO")
    public int getEndingMileage() {
        return endingMileage;
    }

    public void setEndingMileage(int endingMileage) {
        this.endingMileage = endingMileage;
    }

    public String toString() {
        return "Booking #" + bookingNumber + "\n" +
                "Pick-up date: " + getStartingDate() + " at " + getStartingTime() + "\n" +
                "Return date: " + getReturnDate() + " at " + getReturnTime();

    }
}
