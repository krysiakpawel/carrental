package com.rental.domain.vehicle;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    private int id;
    private String make;
    private String model;
    private String licenseNumber;
    private int mileage;
    private int oilChangedAt;
    private double pricePerDay;
    private int status;

    public Vehicle() {
    }

    public Vehicle(String make, String model, String licenseNumber, double pricePerDay) {

        this.make = make;
        this.model = model;
        this.licenseNumber = licenseNumber;
        this.mileage = 0;
        this.oilChangedAt = 0;
        this.pricePerDay = pricePerDay;
        this.status = 1;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "MAKE")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "LICENSE", unique = true)
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Column(name = "MILEAGE")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "LAST_OIL_CHANGE")
    public int getOilChangedAt() {
        return oilChangedAt;
    }

    public void setOilChangedAt(int mileage) {
        this.oilChangedAt = mileage;
    }

    @Column(name = "PRICE_PER_DAY")
    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString() {
        String status;
        if (getStatus() == 1) {
            status = "active";
        } else {
            status = "not active";
        }
        return "Model: " + getModel() + "\n" +
                "Make: " + getMake() + "\n" +
                "License plate number: " + getLicenseNumber() + "\n" +
                "Mileage: " + getMileage() + "\n" +
                "Oil changed at " + getOilChangedAt() + "\n" +
                "Status: " + status;

    }
}
