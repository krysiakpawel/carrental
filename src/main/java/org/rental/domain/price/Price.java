package org.rental.domain.price;

public abstract class Price {

    private int ammount;
    private String currency;


    //dummy data at constructor;
    public Price (){
        this.ammount = 1000;
        this.currency = "EUR0";

    }

    public int getAmmount(){
        return ammount;
    }
    public void setAmmount(int newPrice){
        this.ammount = newPrice;
    }
    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

}

