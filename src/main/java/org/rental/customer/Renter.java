package org.rental.customer;

public class Renter extends Customer {

    private final int id;
    private static int customerCount;
    private String email;
    private long phoneNumber;
    private String passportNumber;

    public Renter(String firstName, String lastName, String email, long phoneNumber, String passportNumber) {
        super(firstName, lastName, email);
        this.phoneNumber = phoneNumber;
        this.passportNumber = passportNumber;
        this.id = ++customerCount;
    }
    public String getFirstName(){
        return super.getFirstName();
    }
    //check in main class if this works pls!
    public void setFirstName(String firstName) {
        super.setFistName(firstName);
    }
    public String getLastName(){
        return  super.getLastName();
    }
    public void setLastName(String lastName){
        super.setLastName(lastName);
    }

    //Add age, and age validation, if younger than XX, you cannot rent a car.
    //Or add Date birthday and automatic age calculation with age validation .


}



