package org.rental.customer;

public class Renter extends Customer{

    private final int id;
    private static int customerCount;
    private String name;
    private String lastname;
    private long phoneNumber;

    public Renter(String name, String lastname){
        this.name = name;
        this.lastname = lastname;
        this.id = ++customerCount;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastName(String lastName){
        this.lastname = lastName;
    }
}
