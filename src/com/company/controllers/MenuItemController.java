package com.company.controllers;

import com.company.Views.MenuView;
import com.company.models.MenuItem;
import com.company.shared.DataReader;
import com.company.shared.ObjectMapper;
import com.company.util.FilePaths;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MenuItemController {

    private static List<MenuItem> menuItemList = new ArrayList<>();

    public static List<MenuItem> getMenuItemList() {
        return menuItemList;
    }


    public static void populateMenuFromFile(){

        //Reading from file
        var list = DataReader.readMenuItems();

        //Mapping data to objects
        var menuItems = ObjectMapper.mapMenuItems(list, FilePaths.getMenuItemsPath());

        //Populating data to List
        menuItemList = menuItems;
    }

    public static void printMenu(){
        MenuView.printMenu(menuItemList);
    }

}
