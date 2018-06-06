package com.lessons;

public class Product implements Item{
    private String name;
    private double price;

    public Product (String name, double price){
        this.name = name;
        this.price = price;
    }

    public Product(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
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
