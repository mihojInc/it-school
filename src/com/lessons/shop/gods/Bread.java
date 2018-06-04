package com.lessons.shop.gods;


import com.lessons.shop.Item;

/**
 * some bread item created by empty constructor
 */
public class Bread implements Item {

    private String name;
    private double price;

    public Bread() {
        this.name = "bread";
        this.price = 7.45;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
