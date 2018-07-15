package com.lessons;

import com.lessons.items.Item;

/**
 * Any factory for produce Item
 */
public class Producer extends Thread {
    private String name;
    private Shop shop;
    private Item itemProduce;

    public Producer(String name, Shop shop, Item itemProduce) {
        this.name = name;
        this.shop = shop;
        this.itemProduce = itemProduce;
    }

    @Override
    public void run() {

        String message;

        while (Shop.getCountGoods() > 1) {
            try {
                sleep(itemProduce.madeTime());

                if (Shop.getCountGoods() > shop.getStock().size()) {
                    message = name;
                    if (shop.addItem(itemProduce)) {
                        message += " produce " + itemProduce.getName();
                    } else {
                        message += " wait then stock is free";
                    }

                    System.out.println(message);
                    WriteReport.write(message);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
