package com.homeworks.phoneShop;

import com.homeworks.phones.AppleSeries.Apple7;
import com.lessons.collection.MyList;
import com.lessons.shop.Item;
import com.lessons.shop.Shop;

/**
 * Created by Mihail Kolomiets on 08.06.18.
 */
public class PhoneShop extends Shop {

    /**
     * Stock
     */
    private MyList stock = new MyList();

    /**
     * Sample sell
     *
     * @param product - any PhoneItems
     */
    @Override
    public void sell(Item product) {
        stock.remove(product);

        // + 20 % from buy price
        money += product.getPrice() * 1.2;
    }

    @Override
    public void addItemToStock(Item product) {
        stock.add(product);
        money -= product.getPrice();
    }

    public MyList getStock() {
        return stock;
    }

}
