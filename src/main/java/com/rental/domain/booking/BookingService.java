package com.rental.domain.booking;

import com.rental.domain.customer.driver.Driver;
import com.rental.domain.customer.driver.DriverDao;
import com.rental.domain.customer.renter.Renter;
import com.rental.domain.customer.renter.RenterDao;
import com.rental.domain.vehicle.Vehicle;
import com.rental.domain.vehicle.VehicleDao;
import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.aspectj.runtime.internal.Conversions.intValue;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;
    @Autowired
    private DriverDao driverDao;
    @Autowired
    private RenterDao renterDao;
    @Autowired
    private VehicleDao vehicleDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingService.class);

    public void saveBooking(Booking booking) throws PropertyValueException {
        try {
            bookingDao.save(booking);
            LOGGER.info("ADDED NEW BOOKING. BOOKING NUMBER " + booking.getBookingNumber());
        } catch (Exception e){
            LOGGER.error("Something went wrong: " + e.getMessage());
        }
    }

    public Booking getBookingByBookingNumber(int bookingNumber) throws Exception {
        try {
            return bookingDao.getBookingByBookingNumber(bookingNumber);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return new Booking();
        }
    }

    // booking statuses : 0 - cancelled ; 1 - active ; 2 - started ; 3 - finished
    public void cancelBooking(int bookingNumber) throws NullPointerException  {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            if (booking.getBookingStatus() == 0) {
                LOGGER.info("CAN NOT CANCELLED BOOKING #" + booking.getBookingNumber() + ". BOOKING IS ALREADY CANCELLED;" );
            } else if (booking.getBookingStatus() == 2) {
                LOGGER.info("CAN NOT CANCELLED BOOKING #" + booking.getBookingNumber() + ". BOOKING CURRENTLY ONGOING;");
            } else if (booking.getBookingStatus() == 3) {
                LOGGER.info("CAN NOT CANCELLED BOOKING #" + booking.getBookingNumber() + ". BOOKING IS ALREADY FINISHED;");
            } else {
                booking.setBookingStatus(0);
                bookingDao.save(booking);
                LOGGER.info("BOOKING #" + booking.getBookingNumber() + " CANCELED;");
            }
        } catch (Exception e) {
            LOGGER.error("Something went wrong: " +  e.getMessage());
        }
    }

    public void openBooking(int bookingNumber) throws NullPointerException {
        try {
        Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            if (booking.getBookingStatus() == 1) {
                booking.setBookingStatus(2);
                booking.setStartingMileage(booking.getVehicle().getMileage());
                bookingDao.save(booking);
                LOGGER.info("BOOKING " + booking.getBookingNumber() + " OPENED;");
            } else if (booking.getBookingStatus() == 0){
                LOGGER.warn("CAN NOT OPEN BOOKING #" + booking.getBookingNumber() + ". BOOKING HAS BEEN CANCELED;");
            } else if (booking.getBookingStatus() ==  2){
                LOGGER.warn("CAN NOT OPEN BOOKING #" + booking.getBookingNumber() + ". BOOKING IS ALREADY STARTED;");
            } else if (booking.getBookingStatus() == 3){
                LOGGER.warn("CAN NOT OPEN BOOKING #" + booking.getBookingNumber() + ". BOOKING IS ALREADY FINISHED;");
            }
        } catch (Exception e) {
            LOGGER.error("Something went wrong: " + e.getMessage());
        }
    }

    public void closeBooking(int bookingNumber, int endingMileage) throws NullPointerException {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            if (booking.getBookingStatus() == 2) {
                if(booking.getVehicle().getMileage() <= endingMileage) {
                    booking.setBookingStatus(3);
                    booking.setEndingMileage(endingMileage);
                    booking.getVehicle().setMileage(endingMileage);
                    bookingDao.save(booking);
                    LOGGER.info("BOOKING #" + booking.getBookingNumber() + " CLOSED;");
                } else {
                    LOGGER.warn("ENDING MILEAGE CAN NOT BE LOWER THAN VEHICLE'S MILEAGE;");
                }
            } else if (booking.getBookingStatus() == 0){
                LOGGER.warn("CAN NOT CLOSE BOOKING #" + booking.getBookingNumber() + ". BOOKING HAS BEEN CANCELED;");
            } else if (booking.getBookingStatus() ==  1){
                LOGGER.warn("CAN NOT CLOSE BOOKING #" + booking.getBookingNumber() + ". BOOKING HAS NOT BEEN STARTED YET;");
            } else if (booking.getBookingStatus() == 3){
                LOGGER.warn("CAN NOT CLOSE BOOKING #" + booking.getBookingNumber() + ". BOOKING IS ALREADY CLOSED;");
            }
        } catch (Exception e) {
            LOGGER.error("Something went wrong: " + e.getMessage());
        }
    }
    public void changeDriver(int bookingNumber, String drivingLicense) throws NullPointerException {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            Driver driver = driverDao.findByDrivingLicenseNumber(drivingLicense);
            booking.setDriver(driver);
            bookingDao.save(booking);
            LOGGER.info("ADDED DRIVER " + driver.getName().toUpperCase() + " " + driver.getLastName().toUpperCase() + " TO BOOKING #" + booking.getBookingNumber());
        } catch (Exception e) {
            LOGGER.warn("Something went wrong " + e.getMessage());
        }
    }
    public void changeRenter(int bookingNumber, String passport) throws NullPointerException {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            Renter renter = renterDao.findByPassportNumber(passport);
            booking.setRenter(renter);
            bookingDao.save(booking);
            LOGGER.info("ADDED RENTER " + renter.getName() + " " + renter.getLastName() + " TO BOOKING #" + booking.getBookingNumber());
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }
    public void changeVehicle(int bookingNumber, String licenseNumber) throws NullPointerException {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            Vehicle vehicle = vehicleDao.getVehicleByLicenseNumber(licenseNumber);
            booking.setVehicle(vehicle);
            calculatePrice(booking);
            bookingDao.save(booking);
            LOGGER.info("VEHICLE SET TO " + vehicle.getModel() + " " + vehicle.getMake() + " " + vehicle.getLicenseNumber() + " FOR BOOKING #" + booking.getBookingNumber());
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }

    public void countTotalDays(int bookingNumber) throws NullPointerException {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            booking.setTotalDays(intValue(Period.between(booking.getStartingDate(), booking.getReturnDate()).getDays()));
            bookingDao.save(booking);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }

    public void calculatePrice(int bookingNumber) throws NullPointerException {
        try {
            Booking booking = bookingDao.getBookingByBookingNumber(bookingNumber);
            double price = (booking.getTotalDays() * booking.getVehicle().getPricePerDay());
            booking.setPrice(price);
            bookingDao.save(booking);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }

    public void calculatePrice(Booking booking) throws PropertyValueException {
        try {
            booking.setPrice(booking.getTotalDays() * booking.getVehicle().getPricePerDay());
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
        }
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookingDao.findAll());
    }

    public List<Booking> getAllBookingsByStartingDate(LocalDate startingDate) {
        return new ArrayList<>(bookingDao.findAllByStartingDate(startingDate));
    }

    public List<Booking> getAllBookingsByReturnDate(LocalDate returnDate) {
        return new ArrayList<>(bookingDao.findAllByReturnDate(returnDate));
    }
}