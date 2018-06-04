package com.lessons.shop;

/**
 * Can create trade point from small sell to supermarket
 */
public abstract class Shop {

    /**
     * All shops start with 100 money, its sample to change
     */
    protected double money = 100.00;

    /**
     * without sells no shops
     *
     * @param product - any gods
     */
    public abstract void sell(Item product);

    //by from distributor
    public abstract void addItemToStock(Item product);

    //added from trim sum by x.xx
    public double getMoney() {
        return Math.floor(money * 100) / 100;
    }
}
