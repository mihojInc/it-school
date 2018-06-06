package com.lessons;


import java.util.Scanner;

public class ConsoleHelper {

    public Shop buildShop(Scanner scanner) {
        Shop shop = new Shop();
        shop.setShopName(getShopName(scanner));
        shop.setBalance(getShopBalance(scanner));
        shop.setGoods(new Item[getShopSize(scanner)]);
        System.out.println("Shop: " + shop.getShopName() + " Start balance is: " + shop.getBalance() + " Number of goods: " + shop.getGoods().length);
        return shop;
    }


    private String getShopName(Scanner scanner) {
        while (true) {
            System.out.println("Hello, enter a shop name: ");
            if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }

    private Double getShopBalance(Scanner scanner) {
        while (true) {
            System.out.println("Enter your start budget: ");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
        }
    }

    private Integer getShopSize(Scanner scanner) {
        while (true) {
            System.out.println("Enter desired numbers of goods in the shop: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
        }
    }

    public ItemType chooseItemType(Scanner scanner) {
        while (true) {
            System.out.println("Please, choose your item type: " + "\n"
                    + "To choose milk, please type " + ItemType.MILK.getItemName() + "\n"
                    + "To choose chocolate, please type " + ItemType.CHOCOLATE.getItemName() + "\n"
                    + "To choose bread, please type " + ItemType.BREAD.getItemName());
            if (scanner.hasNext()) {
                if (scanner.nextInt() == 1) {
                    return ItemType.MILK;
                } else if (scanner.nextInt() == 2) {
                    return ItemType.CHOCOLATE;
                } else if (scanner.nextInt() == 3) {
                    return ItemType.BREAD;
                }
            }
        }
    }


    public Milk createMilk(Scanner scanner) {
        Milk milkItem = new Milk();
        System.out.println("You are creating milk");
        milkItem.setName(getItemName(scanner));
        milkItem.setPrice(getItemPrice(scanner));
        return milkItem;
        }

    public Chocolate createChocolate(Scanner scanner) {
        Chocolate chocolateItem = new Chocolate();
        System.out.println("You are creating chocolate");
        chocolateItem.setName(getItemName(scanner));
        chocolateItem.setPrice(getItemPrice(scanner));
        return chocolateItem;
    }

    public Bread createBread(Scanner scanner) {
        Bread breadItem = new Bread();
        System.out.println("You are creating bread");
        breadItem.setName(getItemName(scanner));
        breadItem.setPrice(getItemPrice(scanner));
        return breadItem;
    }

    public String getItemName(Scanner scanner) {
        while (true) {
            System.out.println("Hello, enter a good name: ");
            if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }

    public Double getItemPrice(Scanner scanner) {
        while (true) {
            System.out.println("Please, enter a good price: ");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
        }
    }

}
