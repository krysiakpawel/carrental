package com.rental.domain.customer.renter;

import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RenterService {

    @Autowired
    private RenterDao renterDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(RenterService.class);

    public boolean addRenter(Renter renter) throws PropertyValueException {
        try {
            renterDao.save(renter);
            LOGGER.info("ADDED NEW RENTER. " + renter.getName() + " " + renter.getLastName());
            return true;
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return false;
        }
    }

    public Renter getRenterByPassport(String passport) throws NullPointerException {
        try {
            return renterDao.findByPassportNumber(passport);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public List<Renter> getRentersByLastName(String name) throws NullPointerException {
        try {
            return renterDao.findAllByLastName(name);
        } catch (Exception e) {
            LOGGER.warn("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    public List<Renter> getAllRenters() {
        return new ArrayList<Renter>(renterDao.findAll());
    }
}