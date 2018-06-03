package com.lessons;

/**
 * This class is a bread model that describes bread parameters and methods.
 */

public class Bread implements Item{
    private String name;
    private Double price;

    Bread(String name, Double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
