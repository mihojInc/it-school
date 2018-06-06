package com.lessons.Products;

import com.lessons.Item;

public class Bread implements Item{
    private String name;
    private double price;

    public Bread (String name, double price){
        this.name = name;
        this.price = price;
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
