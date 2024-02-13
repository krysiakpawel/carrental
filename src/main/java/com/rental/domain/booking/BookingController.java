package com.rental.domain.booking;

import com.rental.domain.customer.driver.Driver;
import com.rental.domain.customer.driver.DriverService;
import com.rental.domain.customer.renter.Renter;
import com.rental.domain.customer.renter.RenterService;
import com.rental.domain.vehicle.Vehicle;
import com.rental.domain.vehicle.VehicleService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private RenterService renterService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private DriverService driverService;

    @RequestMapping(method = RequestMethod.GET, value = "getBooking")
    public Booking getBooking(@RequestParam int bookingNumber) throws Exception {
        return bookingService.getBookingByBookingNumber(bookingNumber);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllBookings")
    public List<Booking> getAllBookings() throws Exception {
        return bookingService.getAllBookings();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookingsByStartingDate")
    public List<Booking> getBookingByStartingDate(@RequestParam LocalDate startingDate) {
        return bookingService.getAllBookingsByStartingDate(startingDate);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookingsByEndingDate")
    public List<Booking> getBookingsByReturnDate(@RequestParam LocalDate returnDate) {
        return bookingService.getAllBookingsByReturnDate(returnDate);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBooking")
    public void addBooking(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startingDate,
                           @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startingTime,
                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate returnDate,
                           @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime returnTime) throws PropertyValueException {
        bookingService.saveBooking(new Booking(startingDate, startingTime, returnDate, returnTime));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeDriver")
    public void changeDriver(@RequestParam int bookingNumber, @RequestParam String drivingLicense) throws Exception {
        bookingService.changeDriver(bookingNumber, drivingLicense);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeRenter")
    public void changeRenter(@RequestParam int bookingNumber, @RequestParam String passport) throws Exception {
        bookingService.changeRenter(bookingNumber, passport);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeVehicle")
    public void changeVehicle(@RequestParam int bookingNumber, String licenseNumber) throws Exception {
        bookingService.changeVehicle(bookingNumber, licenseNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "cancelBooking")
    public void cancelBooking(@RequestParam int bookingNumber) {
        bookingService.cancelBooking(bookingNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "openBooking")
    public void openBooking(@RequestParam int bookingNumber) throws Exception {
        bookingService.openBooking(bookingNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "closeBooking")
    public void closeBooking(@RequestParam int bookingNumber, @RequestParam int endingMileage) throws Exception {
        bookingService.closeBooking(bookingNumber, endingMileage);
    }

    @RequestMapping(method = RequestMethod.POST, value = "testInput")
    public void testInput() throws Exception {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Renter> renters = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();
        Renter renter1 = new Renter("Jan", "Cobolowy", "50023412", "ABC000000", "test@test.com");
        Renter renter2 = new Renter("Tomasz", "Paskalowy", "500234412", "ABC111111", "test1@test.com");
        Renter renter3 = new Renter("Michal", "Ceplusowy", "500234412", "ABC222222", "test@test1.com");
        Renter renter4 = new Renter("Konrad", "Javowoski", "500234412", "ABC333333", "test2@test.com");
        renters.add(renter1);
        renters.add(renter2);
        renters.add(renter3);
        renters.add(renter4);
        Driver driver1 = new Driver("Anna", "Nowak", "852741", 1965, 1, 12);
        Driver driver2 = new Driver("Maria", "Kowalska", "321654", 1993, 10, 14);
        Driver driver3 = new Driver("Janina", "Kwiatkowska", "123456", 1984, 8, 16);
        Driver driver4 = new Driver("Marta", "Testowa", "963852", 1975, 10, 29);
        drivers.add(driver1);
        drivers.add(driver2);
        drivers.add(driver3);
        drivers.add(driver4);
        Vehicle vehicle1 = new Vehicle("Volvo", "XC90", "DI824", 249.0);
        Vehicle vehicle2 = new Vehicle("Volvo", "V50", "RJ534", 195.0);
        Vehicle vehicle3 = new Vehicle("Toyota", "Yaris", "DM121", 119.0);
        Vehicle vehicle4 = new Vehicle("Ford", "Escape", "YO527", 209.0);
        Vehicle vehicle5 = new Vehicle("Hyundai", "i20", "GEU58", 109.0);
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);
        for (Renter renter : renters)
            renterService.addRenter(renter);
        for (Driver driver : drivers)
            driverService.addDriver(driver);
        for (Vehicle vehicle : vehicles)
            vehicleService.addVehicle(vehicle);

        ArrayList<Booking> bookings = new ArrayList<>();
        Booking booking1 = new Booking(LocalDate.of(2024, 1, 1),
                LocalTime.of(9, 30, 0),
                LocalDate.of(2024, 1, 12),
                LocalTime.of(8, 30));
        Booking booking2 = new Booking(LocalDate.of(2024, 1, 1),
                LocalTime.of(12, 30),
                LocalDate.of(2024, 1, 22),
                LocalTime.of(13, 30));
        Booking booking3 = new Booking(LocalDate.of(2024, 2, 8),
                LocalTime.of(11, 30),
                LocalDate.of(2024, 2, 26),
                LocalTime.of(13, 30));
        Booking booking4 = new Booking(LocalDate.of(2024, 3, 15),
                LocalTime.of(22, 0),
                LocalDate.of(2024, 3, 27),
                LocalTime.of(9, 55));

        booking1.setDriver(driver1);
        booking1.setRenter(renter1);
        booking1.setVehicle(vehicle1);
        booking2.setRenter(renter2);
        booking2.setDriver(driver2);
        booking2.setVehicle(vehicle2);
        booking3.setRenter(renter3);
        booking3.setDriver(driver3);
        booking3.setVehicle(vehicle3);
        booking4.setDriver(driver4);
        booking4.setRenter(renter4);
        booking4.setVehicle(vehicle3);

        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookings.add(booking4);
        for (Booking booking : bookings) {
            bookingService.calculatePrice(booking);
            bookingService.saveBooking(booking);
        }
    }
}
