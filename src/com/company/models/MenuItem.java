package com.company.models;

public class MenuItem {

    //Fields
    private final int id;
    private final String itemName;
    private final String briefDescription;
    private final ItemCategory category;
    private final String itemCode;
    private final double itemCost;
    private int orderCount;

    //Constructor
    public MenuItem(int id,String itemName,String briefDescription, ItemCategory category,double itemCost) {
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.itemCost = itemCost;
        this.itemCode = category.getCategoryName().toUpperCase()+""+id;
        this.briefDescription = briefDescription;
    }

    //Getters
    public int getId() {return id;}

    public String getItemName() { return itemName; }

    public ItemCategory getCategory() { return category; }

    public double getItemCost() { return itemCost; }

    public String getItemCode() { return itemCode; }

    public String getBriefDescription() { return briefDescription; }

    public int getOrderCount() { return orderCount; }

    //Setters
    public void setOrderCount(int orderCount) { this.orderCount = orderCount; }

    @Override
    public String toString() {
        return  id + ":\t" + itemCode +"\t"+ itemName + "\t Price: £" + itemCost + "\t Description='" + briefDescription + '\'';
    }
}
