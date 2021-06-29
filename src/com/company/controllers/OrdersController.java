package com.company.controllers;

import com.company.Views.TakeOrderView;
import com.company.models.Customer;
import com.company.models.Order;
import com.company.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdersController {

    private static List<Order> orderList = new ArrayList<>();

    public static List<Order> getOrderList() { return orderList; }
    public static void setOrderList(List<Order> orderList) {
        OrdersController.orderList = orderList;
    }

    public static void printOrders(){
        orderList.forEach(System.out::println);
    }

    private static long menuItemCount;

    public static void takeOrder() {
        menuItemCount = MenuItemController.getMenuItemList().size();
        TakeOrderView.printTakeOrderView(menuItemCount);

        Scanner in = new Scanner(System.in);

        var result = in.nextLine();

        try{
            performOperations(result.trim());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private static void performOperations(String input) throws IOException {

        int optionNumber;
        try{
            optionNumber = Integer.parseInt(input);
        }catch (NumberFormatException e)
        {
            System.out.println("Wrong input format!\t Please Try Again...\n\n");
            return;
        }

        var in = new Scanner(System.in);
        if(optionNumber==0){
            System.out.println(" <- Going back to Main Menu ... ");
            return;
        }

        if(optionNumber>0 && optionNumber<=menuItemCount)
        {
            var desiredMenuItem = MenuItemController.getMenuItemList().get(optionNumber-1);

            var customer = new Customer();
            var newOrder = new Order(customer,desiredMenuItem);

            OrdersController.orderList.add(newOrder);


            System.out.println(" -> Order placed successfully! ");
            System.out.println("Your Order Information is:"+ newOrder);
            System.out.println("****** Thank you for using our service *******");
        }
        else {
            System.out.println(" Invalid Menu Item selected. Please Try Again\n");
        }
    }
}
