package com.company.controllers;

import com.company.models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrdersController {

    private static List<Order> orderList = new ArrayList<>();

    public static List<Order> getOrderList() { return orderList; }
    public static void setOrderList(List<Order> orderList) {
        OrdersController.orderList = orderList;
    }

    public static void printOrders(){
        orderList.forEach(System.out::println);
    }


}
