package com.company.shared;

import com.company.controllers.MenuItemController;
import com.company.models.*;
import com.company.util.Log;
import org.javatuples.Pair;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectMapper {

    public static List<MenuItem> mapMenuItems( List<String> lines, String filePath){

        Log.add("Invoked:  mapMenuItems in "+ObjectMapper.class);

        var categories = new ArrayList<ItemCategory>();

        var menuItemList = new ArrayList<MenuItem>();
        // 0 id(int), 1 Item Name(string), 2 Brief Description(string), 3 Item Cost(double), 4 Item Category (string)
        for (int i = 0, linesSize = lines.size(); i < linesSize; i++) {
            var line = lines.get(i);

            var split = line.split(",");

            //If Length isn't appropriate
            if(split.length != 5) {
                var errorMessage = "Number of cells invalid at row:"+i+" Required cells: 4 | Filepath: "+
                        Paths.get(filePath).toAbsolutePath();
                Log.add("-> Method: "+ObjectMapper.class.getEnclosingMethod()+" Says:"+errorMessage+line);
                new Exception(errorMessage).printStackTrace();
                System.exit(1);
            }

            int id = 0;
            String itemName;
            String briefDescription;
            double itemCost = 0;
            String category;

            // For ID:  Check exception - Number Format Exception
            try{
                id = Integer.parseInt(split[0].trim());
            }catch (NumberFormatException e){
                Log.add(ObjectMapper.class.getEnclosingMethod()+" says: "+"cell 1 of line:"+i+1+
                        " is not correctly formatted: FilePath: "+Paths.get(filePath).toAbsolutePath());
                e.printStackTrace();
            }

            itemName = split[1].trim();
            briefDescription = split[2].trim();

            // For ItemCost: Check exception - Number Format Exception
            try{
                itemCost = Double.parseDouble(split[3].trim());
            }catch (NumberFormatException e){
                Log.add(ObjectMapper.class.getEnclosingMethod()+" says: cell 4 of line:"+i+1+
                        " is not correctly formatted: FilePath: "+Paths.get(filePath).toAbsolutePath());
                e.printStackTrace();
            }
            category = split[4].trim().toUpperCase();

            ItemCategory itemCategory;
            if(!categories.contains(new ItemCategory(category))){
                itemCategory = new ItemCategory(category);
                categories.add(itemCategory);
            }

            itemCategory = categories.stream().filter(obj-> category.equals(obj.getCategoryName())).findFirst().orElse(new ItemCategory(category));

            //Creating new Object
            menuItemList.add(new MenuItem(id,itemName,briefDescription,itemCategory,itemCost));
        }
        return menuItemList;
    }

    //timestamp (Date),customerid (int) ,menuItemCode(MenuItem Category + id),status(bool)
    public static Pair<List<Order>,List<Customer>> mapOrdersAndCustomers(List<String> lines, String filePath) {

        Log.add("Invoked:  mapMenuItems in "+ObjectMapper.class);

        var customers = new ArrayList<Customer>();
        var orders = new ArrayList<Order>();

        for (int i = 0, linesSize = lines.size(); i < linesSize; i++) {
            var line = lines.get(i);

            var split = line.split(",");

            //If Length isn't appropriate
            if(split.length != 4) {
                var errorMessage = "Number of cells invalid at row:"+i+" Required cells: 4 | Filepath: "+
                        Paths.get(filePath).toAbsolutePath();
                Log.add("-> Method: "+ObjectMapper.class.getEnclosingMethod()+" Says:"+errorMessage+line);
                new Exception(errorMessage).printStackTrace();
                System.exit(1);
            }

            var dateStr = split[0].trim();
            var customerIdStr = split[1].trim();
            var menuItemCodeStr = split[2].trim();
            var statusStr = split[3].trim();

            //Parsing string to Date
            SimpleDateFormat df=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
            Date date = null;
            try{
                date = df.parse(dateStr);
            }catch (ParseException e){
                var errorMessage = ObjectMapper.class.getEnclosingMethod()+" says: cell 1 of line:"+(i+1)+"is not correctly formatted: FilePath:"+Paths.get(filePath).toAbsolutePath();
                Log.add(errorMessage);
                new Exception(errorMessage).printStackTrace();
                System.exit(1);
            }
            //Parsing string to customerId int
            int customerId = -1;
            try{
                customerId = Integer.parseInt(customerIdStr);
            }catch (NumberFormatException e){
                Log.add(ObjectMapper.class.getEnclosingMethod()+" says: "+"cell 2 of line:"+i+1+
                        " is not correctly formatted: FilePath: "+Paths.get(filePath).toAbsolutePath());
                e.printStackTrace();
            }

            int finalCustomerId = customerId;
            var customer = customers.stream().filter(c-> c.getCustomerId() == finalCustomerId).findFirst().orElse(null);
            if(customer == null){
                customer = new Customer(customerId);
                customers.add(customer);
            }

            var menuItem = MenuItemController.getMenuItemList().stream().filter(mi-> mi.getItemCode().equalsIgnoreCase(menuItemCodeStr)).findFirst().orElse(null);

            if(menuItem == null){
                var errorMessage = ObjectMapper.class.getEnclosingMethod()+" says: cell 3 of line:"+(i+1)+"is not correctly formatted or Is a new MenuItem: FilePath:"+Paths.get(filePath).toAbsolutePath();
                Log.add(errorMessage);
                new Exception(errorMessage).printStackTrace();
                System.exit(1);
            }

            //Parsing order status (boolean)
            var status = Boolean.parseBoolean(statusStr.toLowerCase());

            orders.add(new Order(customer,menuItem,date));
        }

        return new Pair<>(orders,customers);
    }

}
