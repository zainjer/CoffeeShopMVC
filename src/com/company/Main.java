package com.company;

import com.company.controllers.*;
import com.company.shared.DataReader;
import com.company.shared.ObjectMapper;
import com.company.util.FilePaths;

public class Main {

    public static void main(String[] args) {

        //Reading MenuItems
        MenuItemController.populateMenuFromFile();

        //Reading Orders
        var orders= DataReader.readOrders();

        // Using a Tuple here to get 2 separate lists from Method
        var ordersAndCustomers = ObjectMapper.mapOrdersAndCustomers(orders, FilePaths.getOrdersPath());

        // Populating Model Objects to Controllers
        OrdersController.setOrderList(ordersAndCustomers.getValue0());
        CustomerController.setCustomerList(ordersAndCustomers.getValue1());

        //Generate Servers
        ServerController.generateServers(new String[]{"Charlotte","Jacob","Megan"});

        //Starting Serving
        ServerController.startServing();

        //Initiation
        MainMenuController.initiateMainMenu();
    }
}
