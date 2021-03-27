package com.company.Views;

import com.company.models.Order;

import java.util.List;

public class OrderView {

    public static void printMenu(List<Order> items){
        System.out.println("\n-- Active Orders --\n");
        items.forEach(System.out::println);
        System.out.println("------------------------------------------------\n");

    }
}
