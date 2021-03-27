package com.company.controllers;

import com.company.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    private static List<Customer> customerList = new ArrayList<>();

    public static void setCustomerList(List<Customer> customerList) {
        CustomerController.customerList = customerList;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void printcustomer(){
        customerList.forEach(System.out::println);
    }
}
