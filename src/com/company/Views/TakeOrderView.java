package com.company.Views;

public class TakeOrderView {
    public static void printTakeOrderView(long menuItemCount){
        System.out.println("\n**** Make an Order ****\n");
        System.out.println("* 1 - "+menuItemCount+ " Write any number from MenuItem range to make an order");
        System.out.println("* 0. Exit");
        System.out.println("*************************\n");
        System.out.println("Write a number to continue!\n$ ");
    }
}
