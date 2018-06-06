package com.lessons;

/**
 * This class is a manager for working with goods and counting shop balance.
 */

public class Shop {
    private String shopName;
    private Item[] goods;
    private Double balance;
    private Integer count = 0;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setGoods(Item[] goods) {
        this.goods = goods;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
            for (int i = 0; i < goods.length; i++) {
                if (goods[i] == null) {
                    goods[i] = good;
                    break;
                }
            }
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
        boolean isSold = false;
        for (int i = 0; i < goods.length; i++)
            if (goods[i] != null && goods[i].equals(good)) {
                goods[i] = null;
                System.out.println(good.getName());
                isSold = true;
            }

        if (isSold && count < goods.length) {
            goods[count] = good;
            balance = balance + good.getPrice();
            count = count - 1;
            System.out.println("The good with name " + good.getName() + " with price " + good.getPrice() + " sold");
            System.out.println("Total balance is " + balance + " \n Goods count is: " + count);
        } else {
            System.out.println("The good wasn't sold");
        }
    }

    public void printGoods() {
        if (goods != null) {
            System.out.println("There are " + count + " goods in the shop");
            for (int i = 0; i < goods.length; i++) {
                if (goods[i] != null) {
                    System.out.println(i + " Good name: " + goods[i].getName() + " Good price: " + goods[i].getPrice());
                }
            }
        }
    }

    public Item[] getGoods() {
        return goods;
    }
}

