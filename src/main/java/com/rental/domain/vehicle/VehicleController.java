package com.rental.domain.vehicle;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleController {

        @Autowired
        private VehicleService vehicleService;

        @RequestMapping(method = RequestMethod.POST, value = "addVehicle")
        public void addVehicle(@RequestBody Vehicle vehicle) throws PropertyValueException {
            vehicleService.addVehicle(vehicle);
        }
        @RequestMapping(method = RequestMethod.DELETE, value = "deleteVehicle")
        public void deleteVehicleByLicenseNumber(@RequestParam String licenseNumber) throws NullPointerException {
                vehicleService.deleteVehicleByLicenseNumber(licenseNumber);
        }
        @RequestMapping(method = RequestMethod.PUT, value = "changeOil")
        public void changeOil(@RequestParam String licensePlate, @RequestParam int mileage) throws NullPointerException{
                vehicleService.changeOil(licensePlate, mileage);
        }
        @RequestMapping(method = RequestMethod.GET, value = "getVehicleByLicenseNumber")
        public Vehicle getVehicleByLicenseNumber(@RequestParam String licenseNumber) throws NullPointerException {
                return vehicleService.getVehicleByLicenseNumber(licenseNumber);
        }
        @RequestMapping(method = RequestMethod.GET, value = "getVehiclesByMake")
        public List<Vehicle> getVehiclesByMake(@RequestParam String make){
                return vehicleService.findVehiclesByMake(make);
        }

        @RequestMapping(method = RequestMethod.GET, value = "getAllVehicles")
        public List<Vehicle> getAllVehicles(){
                return vehicleService.findAll();
        }
}
