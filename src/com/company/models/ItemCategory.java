package com.company.models;

import com.company.util.Log;

import java.util.Objects;

public class ItemCategory{

    private final String categoryName;

    //Getter
    public String getCategoryName() {
        return categoryName;
    }

    //constructor
    public ItemCategory(String categoryName) {
        this.categoryName = categoryName;
        //Log.add("Added new Item Category+"+categoryName);
    }

    //Equality Override
    @Override
    public boolean equals(Object o) {

        if(o == this) return true;
        if(!(o instanceof ItemCategory)) return false;

        ItemCategory toCompare = (ItemCategory) o;
        return this.getCategoryName().equalsIgnoreCase(toCompare.getCategoryName());
    }

    @Override
    public int hashCode() {
        return categoryName.hashCode();
    }

    @Override
    public String toString() {
        return categoryName;
    }
}
