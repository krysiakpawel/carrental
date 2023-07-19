package org.rental;

import org.rental.booking.Booking;
import org.rental.booking.BookingService;
import org.rental.customer.Customer;
import org.rental.customer.Driver;
import org.rental.customer.Renter;
import org.rental.vehicle.SmallVehicle;
import org.rental.vehicle.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.plaf.basic.BasicBorders;
import java.awt.print.Book;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        //Create logger later (for remembering)
        System.out.println("LOG INFO: Starting program" + "\n");
        BookingService bookingService = new BookingService();
        
        // Do przemyslenia czy tworzyc najpierw customer a potem przypisac mu wartosc czy wynajmujacy czy kierowca, czy towrzyc osobno wynajmujacy i osobno kierowca
        Customer renter1 = new Renter("John", "Smith", "jsmith@abc.xy", 123456789, "ABC12345");
        Customer renter2 = new Renter("Jan", "Nowak", "nowak@xyz.ab", 987654321, "KLM456789");
        Customer driver2 = new Driver ("Maria", "Nowak", renter2.getEmail(), "GHI555666", 30);
        Customer driver1 = new Driver("Marry", "Smith", renter1.getEmail(), "XYZ999000", 27);
        Vehicle vehicle1 = new SmallVehicle("Toyota","Yaris", "YPP83");
        Vehicle vehicle2 = new SmallVehicle("Toyota","Aygo", "VXT62");
        Booking booking1 = new Booking(renter1,driver1,vehicle1);
        Booking booking2 = new Booking(renter2,driver2,vehicle2);
        Booking booking3 = new Booking(renter2,driver1,vehicle2);
        Booking booking4 = new Booking(renter1,driver2,vehicle1);
        System.out.println(booking1.toString() + "\n");
        System.out.println(booking2.toString() + "\n");
        System.out.println(booking3.toString() + "\n");
        System.out.println(booking4.toString() + "\n");

        bookingService.openBooking(booking1);
        System.out.println(booking1.getStartingMileage());
        bookingService.closeBooking(booking1, 1210);
        System.out.println(booking1.getEndingMileage());
        bookingService.closeBooking(booking1, 10);
        System.out.println(booking1.getEndingMileage());
        bookingService.openBooking(booking1);
        bookingService.openBooking(booking4);
        System.out.println(vehicle1.getMileage());
        System.out.println(booking4.getStartingMileage());
        bookingService.closeBooking(booking4,1847);
        System.out.println(vehicle1.getMileage());
    }
}