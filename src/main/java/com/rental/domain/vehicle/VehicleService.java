package com.rental.domain.vehicle;

import com.rental.domain.booking.Booking;
import com.rental.domain.booking.BookingDao;
import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private BookingDao bookingDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(VehicleService.class);

    public boolean addVehicle(Vehicle vehicle) throws PropertyValueException {
        try {
            vehicleDao.save(vehicle);
            LOGGER.info("ADDED NEW VEHICLE. " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getLicenseNumber());
            return true;
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public Vehicle getVehicleByLicenseNumber(String licenseNumber) throws NullPointerException {
        try {
            return vehicleDao.getVehicleByLicenseNumber(licenseNumber);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public void changeOil(String licensePlate, int mileage) throws NullPointerException {
        try {
            Vehicle vehicle = vehicleDao.getVehicleByLicenseNumber(licensePlate);
            if (vehicle.getMileage() <= mileage) {
                vehicle.setOilChangedAt(mileage);
                vehicle.setMileage(mileage);
                vehicleDao.save(vehicle);
                LOGGER.info("OIL FOR VEHICLE " + vehicle.getLicenseNumber() + " CHANGED AT " + mileage);
            } else {
                LOGGER.warn("MILEAGE IS LOWER THAN CURRENT CAR'S MILEAGE");
            }
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }

    public List<Vehicle> findVehiclesByMake(String make) throws NullPointerException {
        try {
            return new ArrayList<Vehicle>(vehicleDao.findAllByMake(make));
        } catch (Exception e) {
            LOGGER.info("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public void deleteVehicleByLicenseNumber(String licenseNumber) throws NullPointerException {
        try {
            Vehicle vehicle = vehicleDao.getVehicleByLicenseNumber(licenseNumber);
            ArrayList<Booking> bookings = new ArrayList<>(bookingDao.findBookingsByVehicleLicenseNumber(licenseNumber));
            for (Booking booking : bookings) {
                LOGGER.info("BOOKING " + booking.getBookingNumber() + " CHANGED VEHICLE FROM "
                        + booking.getVehicle().getModel() + " "
                        + booking.getVehicle().getMake() + " "
                        + booking.getVehicle().getLicenseNumber() + " TO NULL");
                booking.setVehicle(null);
                bookingDao.save(booking);
            }
            LOGGER.info("DELETED VEHICLE " + vehicle.getMake() + " " + vehicle.getModel() + " " + vehicle.getLicenseNumber());
            vehicleDao.deleteByLicenseNumber(licenseNumber);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }

    public List<Vehicle> findAll() {
        return new ArrayList<Vehicle>(vehicleDao.findAll());
    }
}
