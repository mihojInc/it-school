package com.lessons;

/**
 * This class describe Butter, with settinds and methods
 * this class implements interface Goods
 */
public class Butter implements Goods {
    /**
     * price is current price for sell this good
     * cost is a cost good on the warehouse
     */
    private String name;
    private double price, cost;

    /**
     * constructor which set main settings of Butter
     */
    public Butter(String name, double price, double cost) {
        this.name = name;
        this.price = price;
        this.cost = cost;
    }

    /**
     * This method return name of goods
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * This method set name of goods
     */
    public String setName() {
        return name;
    }

    /**
     * This method return price of goods
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * This method return cost of goods
     */
    @Override
    public double getCost() {
        return cost;
    }

    /**
     *
     * @return name of class
     */
    @Override
    public String toString() {
        return "Butter";
    }

    /**
     *
     * @param obj wich we compare
     * @return if its some object
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Butter other = (Butter) obj;
        if (name != other.name)
            return false;
        if (cost != other.cost)
            return false;
        if (price != other.price)
            return false;
        return true;
    }

}
