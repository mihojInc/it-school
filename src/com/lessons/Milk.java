package com.lessons;

/**
 * This class is a milk model that describes milk parameters and methods.
 */

public class Milk implements Item {
    private String name;
    private Double price;

    Milk(String name, Double price){
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
