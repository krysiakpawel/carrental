package com.rental.domain.customer.renter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenterService {

    @Autowired
    private RenterDao renterDao;

    public Renter addRenter(Renter renter) throws Exception {
        if (renter == null) {
            throw new Exception("Renter is NULL");
        } else {
            return renterDao.save(renter);
        }
    }

    public Renter getRenterByName(String name){
        return new Renter();
    }

}
