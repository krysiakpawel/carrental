package org.rental.workshop;

import org.rental.vehicle.Vehicle;

public class WorkshopService {
Vehicle vehicle;


    public boolean checkIfCarNeedsOil(Vehicle vehicle) {
        if ((vehicle.getMileage()) - ((vehicle.getOilInterval()) * (vehicle.getMileage() / vehicle.getOilInterval())) < 1000) {
            return true;
        } else {
            return false;
        }
    }
    public void startOilChange(){

    }

    public void endOilChange(){}


}
