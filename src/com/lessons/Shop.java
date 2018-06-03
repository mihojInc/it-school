package com.lessons;

/**
 * This class is a manager for working with goods and counting shop balance.
 */

public class Shop {
    private Item[] goods;
    private Double balance;
    private Integer count;

    Shop(Integer goodsSize, Double balance) {
        goods = new Item[goodsSize];
        this.balance = balance;
        count = 0;
    }

/**
* This method increases number of items in the shop and decreases the balance.
*/

    public void buyGood(Item good) {
        if (balance < good.getPrice()) {
            System.out.println("No money");
            return;
        }
        if (count < goods.length) {
            goods[count] = good;
            balance = balance - good.getPrice();
            ++count;
            System.out.println("The good with name " + good.getName() + " with price " + good.getPrice() + " successfully added");
            System.out.println("Total balance is " + balance + " \n Goods count is: " + count);
        } else {
            System.out.println("There is no place for your good");
        }
    }

    /**
     * This method decreases number of items in the shop and increases the balance.
     */
    public void sellGood(Item good) {
        if (count < goods.length) {
            goods[count] = good;
            balance = balance + good.getPrice();
            count = count -1;
            System.out.println("The good with name " + good.getName() + " with price " + good.getPrice() + " sold");
            System.out.println("Total balance is " + balance + " \n Goods count is: " + count);
        } else {
            System.out.println("There is no place for your good");
        }
    }
}

