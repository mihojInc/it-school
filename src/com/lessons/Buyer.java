package com.lessons;

public class Buyer {
    private double sum;
    private Item groceryList[];
    private int inGroceryList = 0;

    Buyer(double cash, int powerOfGroceryList){
        this.sum = cash;
        this.groceryList = new Item[powerOfGroceryList];
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public void setGroceryList(Item groceryList) {
        this.groceryList[inGroceryList] = groceryList;
        inGroceryList++;
    }

    public Item[] getGroceryList() {
        return groceryList;
    }

    public int getInGroceryList() {
        return inGroceryList;
    }

}
