package com.homeworks.phoneShop;

import com.lessons.collection.MyList;
import com.lessons.shop.Item;
import com.lessons.shop.Shop;

/**
 * Shop for sale phones
 */
public class PhoneShop extends Shop {

    /**
     * Phones stock
     */
    private MyList<PhoneItems> stock = new MyList<>();

    /**
     * Sample sell
     *
     * @param product - any PhoneItems
     */
    @Override
    public void sell(Item product) {
        stock.remove((PhoneItems)product);

        // + 20 % from buy price
        money += product.getPrice() * 1.2;
    }

    @Override
    public void addItemToStock(Item product) {
        stock.add((PhoneItems)product);
        money -= product.getPrice();
    }

    public MyList getStock() {
        return stock;
    }

}
