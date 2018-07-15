package com.lessons;

import com.lessons.items.Item;

/**
 * Costumer buy any product. Before buy he think any time.
 */
public class Costumer extends Thread {
    //time for costumer make his choice
    private String name;
    private long thinkingTime;
    private Shop shop;

    public Costumer(Long thinkingTime, Shop shop, String name) {
        this.thinkingTime = thinkingTime;
        this.shop = shop;
        this.name = name;
    }

    @Override
    public void run() {
        String message;
        while (Shop.getCountGoods() > 0) {
            try {
                sleep(thinkingTime);
                Item buyItem = shop.getRandomProduct();
                message = name;

                if (buyItem == null) {
                    message += " wait";
                } else {
                    Shop.incrementCountGoods();
                    message += " buy " + buyItem.getName();
                }

                System.out.println(message);
                WriteReport.write(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
