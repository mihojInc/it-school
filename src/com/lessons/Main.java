package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ConsoleHelper consoleHelper = new ConsoleHelper();
        Bookstore bookstore = consoleHelper.buildBookstore(scanner);
        GoodsType goodsable = consoleHelper.typeGoods(scanner);

        while (true) {
            System.out.println("Что вы хотитет сделать с товаром?");
            System.out.println("Если вы хотите купить товар, ведите " + StoreCommands.BUY_ITEM.getCommandName());
            System.out.println("Если вы хотите продать товар, ведите " + StoreCommands.SELL_ITEM.getCommandName());
            System.out.println("Если вы хотите новый товар, ведите " + StoreCommands.NEW_ITEM.getCommandName());
            System.out.println("Если вы хотите выйти из магазина, введите " + StoreCommands.QUIT.getCommandName());
            if (scanner.hasNext() && scanner.next().equals(StoreCommands.QUIT.getCommandName())) {
                return;
            }
        }

    }
}
