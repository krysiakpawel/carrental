package org.rental.vehicle;

public class VehicleTemp {

    private final int id;
    private static int vehicleCount;
    private String model;
    private String make;
    private String licenseNumber;


    public VehicleTemp(String model, String make, String licenseNumber){
        this.model = model;
        this.make = make;
        this.licenseNumber = licenseNumber;
        this.id = ++vehicleCount;
    }

    public String getMake() {
        return make;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setMake(String make){
        this.make = make;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }

}
