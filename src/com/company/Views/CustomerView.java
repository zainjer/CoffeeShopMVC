package com.company.Views;

import com.company.models.Customer;
import com.company.models.MenuItem;

import java.util.List;

public class CustomerView {

    public static void printMenu(List<Customer> items){
        System.out.println("\n-- Active Customers --\n");
        items.forEach(System.out::println);
        System.out.println("------------------------------------------------\n");

    }


}
