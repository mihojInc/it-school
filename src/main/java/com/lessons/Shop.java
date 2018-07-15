package com.lessons;

import com.lessons.items.Item;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

/**
 * Supermarket
 */
public class Shop {
    private static int countGoods = 40;
    private ArrayList<Item> stock = new ArrayList<>();

    public boolean addItem(Item item) {
        if (stock.size() < 6) {
            stock.add(item);
            return true;
        }
        return false;
    }

    /**
     * get product for stock, product deleted
     * @return object product
     */
    public synchronized Item getRandomProduct() {
        if (stock.size() == 0) {
            return null;
        } else {
            int numberItem = RandomUtils.nextInt(0,stock.size());
            Item getForStock = stock.get(numberItem);
            stock.remove(numberItem);
            return getForStock;
        }
    }

    public ArrayList<Item> getStock() {
        return stock;
    }

    public static int getCountGoods() {
        return countGoods;
    }

    public synchronized static void incrementCountGoods() {
        countGoods--;
    }
}
