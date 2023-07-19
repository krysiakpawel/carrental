package org.rental.vehicle;

public class SmallVehicle extends Vehicle {

    //later add engine size, number of doors, type of petrol, etc

    private int mileage;
    private String vehicleClass;

    public SmallVehicle(String model, String make, String licenseNumber){
        super(model, make, licenseNumber);
        this.vehicleClass = "SMALL";
    }






}
