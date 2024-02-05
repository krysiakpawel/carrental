package com.rental.domain.insurance;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Insurance {

    private int id;
    private String name;
    private double price;
    private int InsuranceRangeId;

    public Insurance(){};
    public Insurance(String name, double price){
        this.name = name;
        this.price = price;
        id++;
    }

    @Id
    @GeneratedValue
    public int getId(){
        return id;
    }
    private void setId(int id){
        this.id = id;
    }

    @Column
    public String getName(){
        return name;
    }

    private void setName(String name){
        this.name = name;
    }

    @Column
    public double getPrice(){
        return price;
    }

    private void setPrice(double newPrice){
        this.price = price;
    }

    @Column
    public int getInsuranceRangeId(){
        return InsuranceRangeId;
    }
    private void setInsuranceRangeId(int id){
        this.InsuranceRangeId = id;
    }



}
