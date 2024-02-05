package com.rental.domain.customer.renter;

import com.rental.domain.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Renter extends Customer {

    private int id;
    private String phoneNumber;
    private String passportNumber;
    private String email;

    public Renter(String name, String lastName, String phoneNumber, String passportNumber, String email){
        super(name, lastName);
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.email = email;
    }
    public Renter(){}

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "PASSPORT")
    public String getPassportNumber(){
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber){
        this.passportNumber = passportNumber;
    }

    @Column(name = "EMAIL")
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}



