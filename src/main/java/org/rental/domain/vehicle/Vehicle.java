package org.rental.domain.vehicle;

import jakarta.persistence.*;
import org.rental.domain.booking.Booking;


@Entity
@Table ( name = "VEHICLES")
public class Vehicle {

    private int id;
    private String model;
    private String make;
    private String licenseNumber;
    private int mileage;
    private Booking booking;

    public Vehicle (){}

    public Vehicle(String model, String make, String licenseNumber){

        this.model = model;
        this.make = make;
        this.licenseNumber = licenseNumber;
        this.mileage = 0;
    }
    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


    @OneToOne(mappedBy = "vehicle")
    public Booking getBooking(){
        return booking;
    }

    public void setBooking(Booking booking){
        this.booking = booking;
    }

    @Column(name = "MODEL")
    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }
    @Column(name = "MAKE")
    public String getMake(){
        return make;
    }
    public void setMake(String make){
        this.make = make;
    }
    @Column (name = "LICENSE")
    public String getLicenseNumber(){
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }

    @Column(name = "MILEAGE")
    public int getMileage(){
        return mileage;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }



}
