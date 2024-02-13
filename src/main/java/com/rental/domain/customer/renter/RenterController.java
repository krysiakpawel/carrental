package com.rental.domain.customer.renter;

import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/renter")
public class RenterController {

    @Autowired
    RenterService renterService;

    @RequestMapping(method = RequestMethod.POST, value = "addRenter")
    public void addRenter(@RequestBody Renter renter) throws PropertyValueException {
        renterService.addRenter(renter);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getRenterByPassport")
    public Renter getRenterByPassport(@RequestParam String passport) throws NullPointerException {
        return renterService.getRenterByPassport(passport);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllRenters")
    public List<Renter> getAllRenters() {
        return renterService.getAllRenters();
    }
    @RequestMapping(method = RequestMethod.GET, value = "getRentersByLastName")
    public List<Renter> getRenterByLastName(@RequestParam String lastname) {
        return renterService.getRentersByLastName(lastname);
    }
}