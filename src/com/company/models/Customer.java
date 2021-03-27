package com.company.models;

import com.company.util.Log;

import java.util.Objects;

public class Customer {

    //Counter
    private static int customerCounter;

    //Fields
    private final int customerId;

    //Getters
    public int getCustomerId() {
        return customerId;
    }

    //Constructor
    public Customer(int customerId) {
        //this.customerId = customerCounter++;
        this.customerId = customerId;
        Log.add("Added new Customer:" +customerId);
        if(customerId>customerCounter)
            customerCounter = customerId;

    }

    public Customer(){
        this.customerId = customerCounter++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId());
    }
}
