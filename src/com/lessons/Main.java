package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item[] items = new Item[1000];

        Scanner scanner = new Scanner(System.in);
        ConsoleHelper consoleHelper = new ConsoleHelper();
        Shop shop = consoleHelper.buildShop(scanner);
        ItemType chooseItem = consoleHelper.chooseItemType(scanner);
        Milk milk = consoleHelper.createMilk(scanner);
        Chocolate chocolate = consoleHelper.createChocolate(scanner);
        Bread bread = consoleHelper.createBread(scanner);

        while (true) {
            System.out.println("What you would like to do? ");
            System.out.println("If you want to buy, type'" + ShopCommands.BUY_ITEM.getCommandName() + "'");
            System.out.println("If you want to sell, type'" + ShopCommands.SELL_ITEM.getCommandName() + "'");
            System.out.println("If you want to create new, type'" + ShopCommands.NEW_ITEM.getCommandName() + "'");
            System.out.println("If you want to close application, type '" + ShopCommands.QUIT.getCommandName() + "'");
            if (scanner.hasNext() && scanner.next().equals(ShopCommands.QUIT.getCommandName())) {
                return;
            }
            for (int i = 0; i < 0; i++)
            if (scanner.hasNext() && scanner.next().equals(ShopCommands.NEW_ITEM.getCommandName())) {
                consoleHelper.chooseItemType(scanner);
                if (consoleHelper.chooseItemType(scanner).equals(1)) {
                    consoleHelper.createMilk(scanner);
                }
                if (consoleHelper.chooseItemType(scanner).equals(2)) {
                    consoleHelper.createChocolate(scanner);
                }
                if (consoleHelper.chooseItemType(scanner).equals(3)) {
                    consoleHelper.createBread(scanner);
                } else {
                    System.out.println("Please, choose one of three items or type 'q' to close application");
                }
                return;
            }

        }
    }
}
