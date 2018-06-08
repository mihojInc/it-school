package com.lessons;

public class Bread implements Item  {
    private String nameOfBread;
    private double priceOfBread;

    Bread (String name, double price){
        this.nameOfBread = name;
        this.priceOfBread = price;
    }
    @Override
    public String getName() {
        return nameOfBread;
    }

    @Override
    public Double getPrice() {
        return priceOfBread;
    }
}
