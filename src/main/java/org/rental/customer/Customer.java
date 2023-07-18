package org.rental.customer;

import java.util.Date;

public abstract class Customer {

    private String firstName;
    private String lastName;
    private String email;

    public Customer (String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
