package com.lessons;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop(3, 9.0);

        Bread bread = new Bread("Хлеб", 3.0);
        Chocolate chocolate = new Chocolate("Milka");
        Milk milk = new Milk("Prostokvashino", 3d);


        shop.buyGood(chocolate);
        shop.buyGood(milk);
        shop.sellGood(bread);
    }
}