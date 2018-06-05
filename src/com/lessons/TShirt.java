package com.lessons;
/*
This class describe TShirt, with settinds and methods
this class implements interface Goods
 */
public class TShirt implements Goods{
    /*
    name save name of goods
     */
    private String name;

    /*
    price is current price for sell this good
    cost is a cost good on the warehouse
     */
    private double price, cost;
    /*
        constructor which set main settings of TShirt
    */
    public TShirt(String name, double price, double cost) {
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
    This method set name of goods
     */
    public String setName() {
        return name;
    }

    /*
    This method return price of goods
     */
    @Override
    public double getPrice() {
        return price;
    }
    /*
    This method return cost of goods
     */
    @Override
    public double getCost() {
        return cost;
    }
}
