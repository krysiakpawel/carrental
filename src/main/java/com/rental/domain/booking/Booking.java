package com.rental.domain.booking;

import com.rental.domain.customer.driver.Driver;
import com.rental.domain.customer.renter.Renter;
import com.rental.domain.vehicle.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

@Entity
@Table(name = "BOOKINGS")
public class Booking {

    private static int bookingCount;
    private int bookingNumber;
    private int id;
    private Vehicle vehicle;
    private Renter renter;
    private Driver driver;
    private double price;
    private LocalDate startingDate;
    private LocalTime startingTime;
    private LocalDate returnDate;
    private LocalTime returnTime;
    private int bookingStatus;
    private int startingMileage;
    private int endingMileage;
    private int totalDays;

    public Booking(LocalDate startingDate, LocalTime startingTime, LocalDate returnDate, LocalTime returnTime) {
        this.startingDate = startingDate;
        this.startingTime = startingTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
        this.bookingNumber = bookingCount++;
        this.bookingStatus = 1;
        this.startingMileage = 0;
        this.endingMileage = 0;
        this.totalDays = Period.between(startingDate, returnDate).getDays();
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
    public Renter getRenter() {
        return renter;
    }

    public void setRenter(Renter renter) {
        this.renter = renter;
    }

    @ManyToOne
    @JoinColumn(name = "DRIVER", referencedColumnName = "ID")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne
    @JoinColumn(name = "VEHICLE", referencedColumnName = "ID", nullable = true)
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Column(name = "BOOKING_NUMBER", nullable = false)
    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    @Column(name = "STARTING_DATE", nullable = false)
    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    @Column(name = "STARTING_TIME", nullable = false)
    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime time) {
        this.startingTime = time;
    }

    @Column(name = "RETURN_DATE", nullable = false)
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Column(name = "RETURN_TIME", nullable = false)
    public LocalTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalTime time) {
        this.returnTime = time;
    }

    @Column(name = "STATUS", nullable = false)
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

    @Column(name = "TOTAL_DAYS")
    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int days) {
        this.totalDays = days;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Booking #" + bookingNumber + "\n" +
                "Pick-up date: " + getStartingDate() + " at " + getStartingTime() + ",\n" +
                "Return date: " + getReturnDate() + " at " + getReturnTime() + ",\n" +
                "Renter: " + getRenter().getName() + " " + getRenter().getLastName() + ",\n" +
                "Driver: " + getDriver().getName() + " " + getDriver().getLastName() + ",\n" +
                "Vehicle: " + getVehicle().getModel() + " " + getVehicle().getMake() + " " + getVehicle().getLicenseNumber() + ",\n" +
                "Price per day: " + getVehicle().getPricePerDay() + ",\n" +
                "Total price: " + getPrice() + ".\n";

    }
}
