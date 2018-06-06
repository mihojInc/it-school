package com.lessons;

import com.lessons.Products.Bread;
import com.lessons.Products.Chocolate;
import com.lessons.Products.Tea;
import com.lessons.Products.Water;

public class Main {

    public static void main(String[] args){
        Shop shop = new Shop(150, 3);
        Shop shop1 = new Shop(15, 3);
        Item chocolate1 = new Chocolate("milka", 58);
        Item chocolate2 = new Chocolate("Chayka", 30);
        Item water1 = new Tea("monarch", 40);
        Item bread1 = new Bread("bread", 20);

        System.out.println("********Shop1********");
        shop.buyProduct(chocolate1);
        shop.buyProduct(water1);
        shop.buyProduct(bread1);
        shop.buyProduct(chocolate2);
        shop.showProducts();
        shop.showCash();
        shop.sellProduct("milka");
        shop.sellProduct("hdrtd");

        System.out.println("\n********Shop2********");
        shop1.buyProduct(chocolate1);
        shop1.buyProduct(water1);
        shop1.showProducts();
        shop1.showCash();
        shop1.sellProduct("milka");
    }
}
