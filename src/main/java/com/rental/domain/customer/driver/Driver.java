package com.rental.domain.customer.driver;

import com.rental.domain.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Driver extends Customer {

    private int id;
    private String drivingLicenseNumber;
    private LocalDate DOB;

    public Driver (String name, String lastName, String drivingLicenseNumber, int year, int month, int day){
        super(name, lastName);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.DOB = LocalDate.of(year, month, day);
    }
    public Driver (String name, String lastName, String drivingLicenseNumber, LocalDate DOB){
        super(name, lastName);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.DOB = DOB;
    }

    public Driver(){}

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "DRIVING_LICENSE_NO", unique = true)
    public String getDrivingLicenseNumber(){
        return drivingLicenseNumber;
    }
    public void setDrivingLicenseNumber(String drivingLicenseNumber){
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    @Column(name = "DOB")
    public LocalDate getDOB(){
        return DOB;
    }

    public void setDOB(LocalDate DOB){
        this.DOB = DOB;
    }
    public void setDOB(int year, int month, int day){
        this.DOB = LocalDate.of(year, month, day);
    }

    public String toString(){
        return "Driver: " + super.toString() + "\n" +
                "Driving license number: " + getDrivingLicenseNumber() + "\n" +
                "Date of birth" + getDOB() + "\n";
    }
}
