package com.lessons;

import com.lessons.items.Fish;
import com.lessons.items.Item;
import com.lessons.items.Meat;
import com.lessons.items.Milk;

public class App {
    public static void main(String[] args) {

        Shop shop = new Shop();

        Costumer petya = new Costumer(800l, shop, "Petya");
        Costumer vasya = new Costumer(1000l, shop, "Vasya");
        Producer milkProducer = new Producer("Cowgirls", shop, new Milk());
        Producer meatProducer = new Producer("Cowboys", shop, new Meat());
        Producer fishProducer = new Producer("Fishmen", shop, new Fish());

        petya.start();
        vasya.start();
        milkProducer.start();
        meatProducer.start();
        fishProducer.start();

        try {
            petya.join();
            vasya.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WriteReport.countAndWriteAllStory();

    }


}
