package com.lessons.Products;

import com.lessons.Item;

public class Bread implements Item{
    /**
     * var name sets product name;
     * var price sets product price
     */
    private String name;
    private double price;

    /**
     * constructor sets product name and price
     * @param name
     * @param price
     */
    public Bread (String name, double price){
        this.name = name;
        this.price = price;
    }

    /**
     * method gets product name
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * method gets product price
     * @return
     */
    @Override
    public double getPrice() {
        return price;
    }
}
