package com.rental.domain.workshop;

import com.rental.domain.vehicle.Vehicle;
import com.rental.config.DbManager;

import java.sql.SQLException;

public class WorkshopService {

    Vehicle vehicle;

    /*
    public boolean checkIfCarNeedsOil(Vehicle vehicle) {
        return  ((vehicle.getOilInterval()) - ((vehicle.getMileage()) - ((vehicle.getMileage() / vehicle.getOilInterval()) * vehicle.getOilInterval())) <= 1000 );
    }

    public void changeOil(Vehicle vehicle){
        vehicle.setOilWasChanged(true);
        System.out.println("INFO: Oil in " + vehicle.getLicenseNumber() + " has been changed.");
    }

    */
    public void changeTires(Vehicle vehicle){
    }

    // Temporary here, do not delete for now pls

    //************************************************
    public void testConnection() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        System.out.println(dbManager.getConnection());
    }
    //************************************************


}
