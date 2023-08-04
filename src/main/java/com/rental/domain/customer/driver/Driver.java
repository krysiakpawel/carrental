package com.rental.domain.customer.driver;

import com.rental.domain.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Driver extends Customer {

    private String drivingLicenseNumber;
    private LocalDate DOB;

    public Driver (String name, String lastName, String drivingLicenseNumber, LocalDate DOB){
        super(name, lastName);
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.DOB = DOB;
    }
    public Driver(){};


    @Column(name = "DRIVING_LICENSE_NO")
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
}
