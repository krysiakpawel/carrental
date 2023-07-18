package org.rental.customer;

public class Driver extends Customer{

    private String drivingLicenseNumber;
    private int age;

    public Driver (String name, String lastname, String email, String drivingLicenseNumber, int age){
        super(name,lastname,email);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.age = age;
    }
}
