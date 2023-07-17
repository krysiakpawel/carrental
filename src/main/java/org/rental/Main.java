package org.rental;

import org.rental.booking.Booking;
import org.rental.customer.Customer;
import org.rental.price.Price;
import org.rental.vehicle.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        Vehicle Duster1 =  new Vehicle("Dacia","Duster", "MYM48");
        Vehicle Duster2 =  new Vehicle("Dacia","Duster", "NBS92");
        Customer John = new Customer("John", "Doe");
        Customer Adam = new Customer("Adam", "Smith");
        Price price = new Price();
        Booking booking1 = new Booking(John, Duster1, price);
        System.out.println(booking1.toString());
        Booking booking2 = new Booking(Adam, Duster2, price);
        Booking booking3 = new Booking(Adam, Duster1, price);
        System.out.println(booking2.toString());
        System.out.println(booking3.toString());
        Booking booking4 = new Booking(Adam, Duster1, price);

    }
}