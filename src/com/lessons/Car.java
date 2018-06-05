package com.lessons;
/*
This class describe car, with settinds and methods
this class implements interface Goods
 */
public class Car implements Goods{
    /*
    price is current price for sell this good
    cost is a cost good on the warehouse
   */
    private String name;
    private double price, cost;

    /*
    constructor which set main settings of car
     */
    public Car(String name, double price, double cost) {
        this.name = name;
        this.price = price;
        this.cost = cost;
    }

    /*
    This method return name of goods
     */
    @Override
    public String getName() {
        return name;
    }

    /*
    This method return price of goods
     */
    public String setName() {
        return name;
    }

    /*
    This method return cost of goods
     */
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
