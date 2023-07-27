package org.rental.controller;

import org.rental.domain.vehicle.Vehicle;
import org.rental.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleController {
        @Autowired
        private VehicleService vehicleService;

        @PutMapping(value = "addVehicle")
        public void addVehicle(@RequestBody Vehicle vehicle){
            vehicleService.saveVehicle(vehicle);

        }
}
