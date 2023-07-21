package org.rental.workshop;

import org.rental.vehicle.Vehicle;

public class WorkshopService {

Vehicle vehicle;

    public boolean checkIfCarNeedsOil(Vehicle vehicle) {
        return ((vehicle.getOilInterval()) - ((vehicle.getMileage()) - ((vehicle.getMileage() / vehicle.getOilInterval()) * vehicle.getOilInterval()))) <= 1000;
    }

    public void startOilChange(){

    }

    public void endOilChange(){}


}
