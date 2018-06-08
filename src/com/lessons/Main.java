package com.lessons;

import com.lessons.Products.Bread;
import com.lessons.Products.Chocolate;
import com.lessons.Products.Tea;
import com.lessons.Products.Water;

public class Main {

    public static void main(String[] args){
        Shop shop = new Shop(400, 0.5, 5);
        Interaction interaction = new Interaction(40, shop);

        interaction.startChoice();

    }
}
