package com.homeworks.phoneShop;

import com.homeworks.phones.AndroidSeries.FlyFS1050;
import com.homeworks.phones.AppleSeries.Apple;
import com.homeworks.phones.AppleSeries.Apple7;
import com.homeworks.phones.AppleSeries.SuperIphone;
import com.homeworks.phones.Phone;
import com.lessons.collection.MyList;
import com.lessons.shop.Item;

/**
 * Demonstrate work of phoneShop by previous classes
 */
public class Main {

    public static void main(String[] args) {

        PhoneShop myNewShop = new PhoneShop();

        //buy phones
        myNewShop.addItemToStock(new PhoneItems(new Apple7(), 20));
        myNewShop.addItemToStock(new PhoneItems(new FlyFS1050(), 2));
        myNewShop.addItemToStock(new PhoneItems(new SuperIphone(), 50));

        //show phones ...
        for (int i = 0, items = 0; items < myNewShop.getStock().size(); i++) {
            if (myNewShop.getStock().get(i) != null) {
                PhoneItems phone = (PhoneItems) myNewShop.getStock().get(i);
                System.out.println("Phone: " + phone.getName() + ", price: " + phone.getPrice() * 1.2);
                items++;
            }
        }

        System.out.println("\nPhoneShop money: " + myNewShop.getMoney());

        //primitive sell phone
        MyList stock = myNewShop.getStock();
        myNewShop.sell((Item) stock.get(1));

        System.out.println("PhoneShop money after sell: " + myNewShop.getMoney() + "\n");

        //now show stock
        for (int i = 0; i < 3; i++) {
            PhoneItems phone = (PhoneItems) stock.get(i);
            if (phone != null)
                System.out.println("Phone: " + phone.getName() + ", price: " + phone.getPrice() * 1.2);
        }

        //get info about phone in stock
        PhoneItems phoneItems = (PhoneItems)stock.get(0);
        Phone phone = phoneItems.getPhone();

        if (phone instanceof Apple)
            System.out.println(((Apple) phone).getInfo());
    }
}
