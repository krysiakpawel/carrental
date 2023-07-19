package org.rental.customer;

public class Driver extends Customer{

    private String drivingLicenseNumber;
    private int age;

    public Driver (String name, String lastname, String email, String drivingLicenseNumber, int age){
        super(name,lastname,email);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.age = age;
    }

    //Add age, and age validation, if younger than XX, you cannot drive a car.
    //Or add Date birthday and automatic age calculation with age validation .
}
