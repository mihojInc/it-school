package com.lessons.shop;


import com.lessons.shop.gods.*;

import java.util.Scanner;

/**
 * Demonstration mini street shop is work
 */
public class Main {

    public static void main(String[] args) {

        //our trade point
        Kiosk kiosk = new Kiosk();

        //show start 100$ without trimmer methods, just directly
        System.out.println("Money from start trading: " + kiosk.money + " $");

        //create products
        Product meat = new Product("Meat", 20.08);
        Product milk = new Product("Milk", 10.40);
        Product beer = new Product("Beer", 15.20);

        //uploading stock
        kiosk.addItemToStock(meat);
        kiosk.addItemToStock(milk);
        kiosk.addItemToStock(beer);

        //uploaded stock different any items
        kiosk.addItemToStock(new Water());
        kiosk.addItemToStock(new Bread());
        kiosk.addItemToStock(new PaperForPrinter());

        //uploaded stock more
        kiosk.addItemToStock(milk);

        //no money from bue more paper
        kiosk.addItemToStock(new PaperForPrinter());


        //get our money
        System.out.println("Money our kiosk: " + kiosk.getMoney());

        //Stock info
        System.out.println("Stock info:");
        kiosk.stock.getInfoAbout();

        //sell milk
        kiosk.sell(milk);
        kiosk.sell(kiosk.stock.getProductByName("Paper"));

        //show info
        System.out.println("Money our kiosk after sell milk: " + kiosk.getMoney());
        kiosk.stock.getInfoAbout();

        //try fulling stock by breads
        kiosk.addItemToStock(new Bread());
        kiosk.addItemToStock(new Bread());
        kiosk.addItemToStock(new Bread());
        kiosk.addItemToStock(new Bread());
        kiosk.addItemToStock(new Bread());

        //sell all production
        for (Item item : kiosk.stock.getProducts()) {
            if (item != null)
                kiosk.sell(item);
        }

        System.out.println("After all salling:\nNow our trade point have " + kiosk.getMoney() + "$.\n" +
                "----- console choice, (h) for help------");

        /**
         * further user choice from console
         */
        Scanner scanner = new Scanner(System.in);

        String action;
        Costumer costumer = null;
        do {
            action = scanner.nextLine();

            switch (action) {

                /**
                 * menu
                 */
                case "h":
                    System.out.println("c - create new costumer, b - buy, a - add gods to the stock,\n" +
                            "i - info about costumer, s - info about shop, p - info about products on shop");
                    break;

                /**
                 * create new costumer
                 */
                case "c":
                    System.out.println("Enter name of new costumer:");
                    String name = scanner.nextLine();
                    System.out.println(".. and his money:");
                    try {
                        costumer = new Costumer(name, Double.valueOf(scanner.nextLine()));
                    } catch (NumberFormatException nfe) {
                        costumer = new Costumer(name, 50.0);
                        System.out.println("You entered unknown number. " + name + " set default 50$.");
                    }
                    System.out.println("Create costumer with name " + name + " and " + costumer.getMoney() + "$.");
                    break;

                /**
                 * costumer buy
                 */
                case "b":
                    if (costumer == null) {
                        System.out.println("We haven't a costumer. Please create his (c)");
                        break;
                    }
                    System.out.println("That product " + costumer.getName() + " want a buy?:");
                    String productName = scanner.nextLine();

                    Item item = kiosk.stock.getProductByName(productName);
                    if (costumer.countGodsInCart() == 5)
                        System.out.println("The costumer's cart is full.");
                    else if (item != null) {
                        costumer.buy(item);
                        kiosk.sell(item);
                        System.out.println(costumer.getName() + " buy " + item.getName());
                    } else {
                        System.out.println(productName + " not in the store.");
                    }
                    break;

                /**
                 * add product in the stock
                 */
                case "a":

                    //sample exit from case 'a' if stock is full
                    if (kiosk.getFilledStock() == 10) {
                        //try add 11 item =). Can write System.out.println()
                        kiosk.addItemToStock(new Bread());
                        break;
                    }

                    Bread bread = new Bread();
                    PaperForPrinter paper = new PaperForPrinter();
                    Water water = new Water();

                    System.out.println("Kiosk have " + kiosk.getMoney() +
                            "\nChoice a product: 1 - bread " + kiosk.getPriceWithMarg(bread.getPrice()) +
                            ", 2 - Paper " + kiosk.getPriceWithMarg(paper.getPrice()) +
                            ", 3 - water " + kiosk.getPriceWithMarg(water.getPrice()) +
                            ", n - your custom product:");
                    String addProductChoice = scanner.nextLine();
                    String nameAddedProduct;
                    if (addProductChoice.equals("1")) {
                        kiosk.addItemToStock(bread);
                        nameAddedProduct = bread.getName();
                    } else if (addProductChoice.equals("2")) {
                        kiosk.addItemToStock(paper);
                        nameAddedProduct = paper.getName();
                    } else if (addProductChoice.equals("3")) {
                        kiosk.addItemToStock(water);
                        nameAddedProduct = water.getName();
                    } else {
                        System.out.println("Input new product name: ");
                        nameAddedProduct = scanner.nextLine();
                        Product product;
                        try {
                            System.out.println("..and his price for sell (10$ by default)");
                            product = new Product(nameAddedProduct, Double.valueOf(scanner.nextLine()));
                        } catch (NumberFormatException nfe) {
                            product = new Product(nameAddedProduct, 10);
                        }
                        kiosk.addItemToStock(product);
                    }
                    System.out.println("Product " + nameAddedProduct + " added to the stock.");
                    break;

                /**
                 * information about costumer
                 */
                case "i":
                    if (costumer != null) {
                        System.out.println("Costumer " + costumer.getName() + " have " + costumer.getMoney() + "$.");
                        costumer.getInfoAboutCart();
                    } else
                        System.out.println("There is no costumer, please create him (c)");
                    break;

                /**
                 * information about our shop
                 */
                case "s":
                    System.out.println("Kiosk have " + kiosk.getMoney() + "$ and stock filled by " + kiosk.getFilledStock());
                    break;

                /**
                 * information about shop products in the stall(or stock)
                 */
                case "p":
                    String stall = "Kiosk have next product:";
                    for (Item stockItem : kiosk.stock.getProducts())
                        if (stockItem != null) {
                            stall += " " + stockItem.getName() + " - " + stockItem.getPrice() + "$,";
                        }
                    //format end of strings by .
                    stall = stall.substring(0, stall.length() - 1) + ".";

                    if (kiosk.getFilledStock() == 0)
                        stall = "Kiosk haven't a products, sorry";
                    System.out.println(stall);
                    break;

            }

        } while (!action.equals("q"));


        scanner.close();
    }

}
