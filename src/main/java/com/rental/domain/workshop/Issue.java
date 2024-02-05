package com.rental.domain.workshop;

import com.rental.domain.employees.Employee;
import com.rental.domain.vehicle.Vehicle;

public class Issue {

    static int IssueId;
    private int issueCategory;
    private Employee reportedBy;
    private Employee mechanic;
    private Vehicle vehicle;
    private int IssueStatus;
    public Issue(){
    }

    public int getIssueId(){
        return IssueId;
    }
    public int getIssueCategory(){
        return issueCategory;
    }
    public void setIssueCategory(int issueCategory){
        this.issueCategory = issueCategory;
    }
    public Employee getReportedBy(){
        return reportedBy;
    }
    public void setReportedBy(Employee employee){
        this.reportedBy = employee;
    }
    public Employee getMechanic() {
        return mechanic;
    }
    public void setMechanic(Employee mechanic) {
        this.mechanic = mechanic;
    }
    public Vehicle getVehicle(){
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }





}
