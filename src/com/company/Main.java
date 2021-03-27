package com.company;

import com.company.controllers.CustomerController;
import com.company.controllers.MainMenuController;
import com.company.controllers.MenuItemController;
import com.company.controllers.OrdersController;
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

        //Initiation
        MainMenuController.initiateMainMenu();
    }
}
