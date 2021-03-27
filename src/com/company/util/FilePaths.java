package com.company.util;

public class FilePaths {

    private static final String menuItemsPath = "/resources/menuitems.csv";
    private static final String ordersItemsPath = "/resources/orders.csv";
    private static final String LogFilePath = "/log/log.txt";

    public static String getMenuItemsPath() {
        return System.getProperty("user.dir")+ menuItemsPath;
    }

    public static String getLogFilePath() {
        return System.getProperty("user.dir")+LogFilePath;
    }

    public static String getOrdersPath() { return System.getProperty("user.dir")+ordersItemsPath; }
}
