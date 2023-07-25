package org.rental;

import org.rental.booking.Booking;
import org.rental.booking.BookingService;
import org.rental.customer.Customer;
import org.rental.customer.Driver;
import org.rental.customer.Renter;
import org.rental.vehicle.SmallVehicle;
import org.rental.vehicle.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.rental.workshop.WorkshopService;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(Main.class, args);

    /*
        //Create logger later (for remembering)
        System.out.println("LOG INFO: Starting program" + "\n");
        BookingService bookingService = new BookingService();
        WorkshopService workshopService = new WorkshopService();
        
        // Do przemyslenia czy tworzyc najpierw customer a potem przypisac mu wartosc czy wynajmujacy czy kierowca, czy tworzyc osobno wynajmujacy i osobno kierowca
        Customer renter1 = new Renter("John", "Smith", "jsmith@abc.xy", 123456789, "ABC12345");
        Customer driver1 = new Driver("Marry", "Smith", renter1.getEmail(), "XYZ999000", 27);
        Vehicle vehicle1 = new SmallVehicle("Toyota","Yaris", "YPP83");
        Booking booking1 = bookingService.createNewBooking(renter1,driver1);
        bookingService.addVehicleToBooking(booking1,vehicle1);
        bookingService.modifyPickUpDate(booking1, LocalDate.parse("2023-07-24"));
        bookingService.modifyReturnDate(booking1, LocalDate.parse("2023-07-26"));
        booking1.setStartingTime(LocalTime.parse("10:30:00"));
        booking1.setReturnTime(LocalTime.parse("22:00:00"));

        System.out.println(booking1.toString());

        workshopService.testConnection();

        */
    }
}