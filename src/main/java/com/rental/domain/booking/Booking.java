package com.rental.domain.booking;

import com.rental.domain.customer.Customer;
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
    private Long id;
    private Vehicle vehicle;
    private Renter renter;
    private Customer driver;
    private Price price;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private boolean bookingWasOpened;
    private boolean bookingIsClosed;
    private boolean bookingIsRunning;
    private int startingMileage;
    private int endingMileage;

    public Booking(LocalDate startingDate, LocalTime startingTime, LocalDate returnDate, LocalTime returnTime) {
        this.startingDate = startingDate;
        this.startingTime = startingTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.bookingNumber = bookingCount++;
        this.bookingWasOpened = false;
        this.bookingIsClosed = false;
        this.bookingIsRunning = false;
        this.startingMileage = 0;
        this.endingMileage = 0;
    }

    public Booking() {
        this.bookingNumber = bookingCount++;
        this.bookingWasOpened = false;
        this.bookingIsClosed = false;
        this.bookingIsRunning = false;
        this.startingMileage = 0;
        this.endingMileage = 0;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @OneToOne(optional = true)
    @JoinColumn(name = "RENTER_ID", referencedColumnName = "ID")
    public Renter getRenter(){
        return renter;
    }
    public void setRenter(Renter renter){
        this.renter = renter;
    }
   /*
    @OneToOne(optional = true)
    @JoinColumn(name = "VEHICLE_ID" , referencedColumnName = "ID")
    public Vehicle getVehicle(){
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }
    */


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

    @Column(name = "WAS_OPENED")
    public boolean getBookingWasOpened() {
        return bookingWasOpened;
    }

    public void setBookingWasOpened(boolean wasOpened) {
        this.bookingWasOpened = wasOpened;
    }

    @Column(name = "IS_CLOSED")
    public boolean getBookingIsClosed() {
        return bookingIsClosed;
    }

    public void setBookingIsClosed(boolean bookingIsClosed) {
        this.bookingIsClosed = bookingIsClosed;
    }

    @Column(name = "IS_RUNNING")
    public boolean getBookingIsRunning() {
        return bookingIsRunning;
    }

    public void setBookingIsRunning(boolean bookingIsRunning) {
        this.bookingIsRunning = bookingIsRunning;
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
