package com.company.Views;

import com.company.models.MenuItem;

import java.util.List;

public class MenuView {

    public static void printMenu(List<MenuItem> menuItems){
        System.out.println("\n\t-- Shop Menu --\n");
        menuItems.forEach(System.out::println);
        System.out.println("------------------------------------------------\n");

    }

}
