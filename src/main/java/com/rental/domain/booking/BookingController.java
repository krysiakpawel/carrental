package com.rental.domain.booking;

import com.rental.domain.customer.driver.Driver;
import com.rental.domain.customer.driver.DriverService;
import com.rental.domain.customer.renter.Renter;
import com.rental.domain.customer.renter.RenterService;
import com.rental.domain.vehicle.Vehicle;
import com.rental.domain.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

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

    @RequestMapping(method = RequestMethod.POST, value = "testInput")
    public void testInput() throws Exception {
        Renter renter1 = new Renter("Jan", "Nowak", "50023412", "ABC14123", "test@test.com");
        Renter renter2 = new Renter("Tomasz", "Murarczyk", "500234412", "ABC1224423", "test@test.com");
        Driver driver1 = new Driver("Anna", "Nowak", "5034525412", LocalDate.now());
        Driver driver2 = new Driver("Maria", "Kowalska", "50234412", LocalDate.now());
        Vehicle vehicle1 = new Vehicle("Volvo","XC90","DI824");
        Vehicle vehicle2 = new Vehicle("Volvo", "V50", "RJ534");
        Vehicle vehicle3 = new Vehicle("Toyota","Yaris","DM121");
        renterService.addRenter(renter1);
        renterService.addRenter(renter2);
        driverService.addDriver(driver1);
        driverService.addDriver(driver2);
        vehicleService.addVehicle(vehicle1);
        vehicleService.addVehicle(vehicle2);
        vehicleService.addVehicle(vehicle3);
        Booking booking1 = new Booking(LocalDate.of(2024,2,3),
                                        LocalTime.of(15,30),
                                        LocalDate.of(2024,2,10),
                                        LocalTime.of(10,00));
        Booking booking2 = new Booking(LocalDate.of(2024, 2, 7),
                                        LocalTime.of(9,45),
                                        LocalDate.of(2024,02,14),
                                        LocalTime.of(22,15));
        booking1.setDriver(driver1);
        booking1.setRenter(renter1);
        booking1.setVehicle(vehicle1);
        booking2.setDriver(driver1);
        booking2.setRenter(renter1);
        booking2.setVehicle(vehicle1);
        bookingService.saveBooking(booking1);
        bookingService.saveBooking(booking2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBooking")
    public Booking getBooking(@RequestParam int bookingNumber){
        Booking booking = bookingService.getBookingByBookingNumber(bookingNumber);
        return booking;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBooking")
    public void createBooking(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "cancelBooking")
    public void cancelBooking(@RequestParam int bookingNumber){
        bookingService.cancelBooking(bookingNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "openBooking")
    public void openBooking(@RequestParam int bookingNumber) throws Exception{
        bookingService.openBooking(bookingNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "closeBooking")
    public void closeBooking(@RequestParam int bookingNumber, @RequestParam int endingMileage) throws Exception {
        bookingService.closeBooking(bookingNumber, endingMileage);



    }
}
