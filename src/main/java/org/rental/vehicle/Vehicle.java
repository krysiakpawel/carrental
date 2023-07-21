package org.rental.vehicle;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Vehicle {


    private int id;
    private static int vehicleCount;
    private String model;
    private String make;
    private int mileage;
    private String licenseNumber;
    private int oilInterval = 7500;

    public Vehicle(String model, String make, String licenseNumber){
        this.id = ++vehicleCount;
        this.model = model;
        this.make = make;
        this.mileage = 0;
        this.licenseNumber = licenseNumber;
    }

    public int getId(){
        return id;
     }
    public String getModel(){
        return model;
     }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMake(){
        return make;
     }
    public void setMake(String make){
        this.make = make;
     }
     public int getMileage(){
        return mileage;
     }

    public void setMileage(int newMileage) {
        if(newMileage > mileage) {
            this.mileage = newMileage;
        } else {
            System.out.println("Nowy przebieg nie moze byc nizszy nie poprzedni");
        }
    }
    public String getLicenseNumber(){
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }
    public String toString(){
        return getModel() + " " + getMake() + "\n"
                + "Mileage: " + getMileage();
    }
}
