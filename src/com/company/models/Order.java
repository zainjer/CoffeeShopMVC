package com.company.models;

import java.util.Date;

public class Order {

    private static int orderCounter;

    //Fields
    private final int id;
    private final Date timestamp;
    private final Customer customer;
    private final MenuItem menuItem;
    private boolean status;

    //Constructor
    public Order(Customer customer, MenuItem menuItem) {
        id = orderCounter++;
        // gets the current system time
        timestamp = new Date(System.currentTimeMillis());
        this.customer = customer;
        this.menuItem = menuItem;
        this.status = false;
    }

    public Order(Customer customer, MenuItem menuItem, Date timestamp) {
        id = orderCounter++;
        // gets the current system time
        this.timestamp = timestamp;
        this.customer = customer;
        this.menuItem = menuItem;
        this.status = false;
    }

    //getters
    public int getId() {return id;}

    public Date getTimestamp() { return timestamp; }

    public Customer getCustomer() { return customer; }

    public MenuItem getMenuItem() { return menuItem; }

    public boolean isStatus() { return status; }

    public String getOrderStatus() {
        if(status) return "Delivered!";
    else return "In Queue...";
    }

    //Setters
    public void setStatus(boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", status=" + getOrderStatus() +
                ", customer=" + customer.toString() +
                ", menuItem=" + menuItem.toString() +
                '}';
    }
}
