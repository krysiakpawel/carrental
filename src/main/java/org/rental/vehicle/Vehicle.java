package org.rental.vehicle;

public abstract class Vehicle {


    private int id;
    private static int vehicleCount;
    private String model;
    private String make;
    private int mileage;
    private String licenseNumber;
    private int oilInterval = 10000;
    private boolean oilWasChanged = true;

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

    public int getOilInterval() {
         return oilInterval;
    }
    public void setOilInterval(int oilInterval) {
        this.oilInterval = oilInterval;
    }
  
    public void setMake(String make){
        this.make = make;
    }

    public int getMileage(){
        return mileage;
     }
     public boolean getOilWasChanged(){
        return oilWasChanged;
     }
     public void setOilWasChanged(boolean oilWasChanged){
        this.oilWasChanged = oilWasChanged;
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
        return  getModel() + " " + getMake() + " " + getLicenseNumber();
    }
}
