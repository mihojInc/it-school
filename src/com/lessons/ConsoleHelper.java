package com.lessons;

import java.util.Scanner;

/**
 * Create class ConsoleHelper in order to create objects through Scanner
 */
public class ConsoleHelper {
    /**
     * The method that creates a store
     *
     * @param scanner
     * @return
     */
    public Bookstore buildBookstore(Scanner scanner) {
        Bookstore bookstore = new Bookstore();
        bookstore.setNameBookstore(getNameStore(scanner));
        bookstore.setCashAmount(getCashAmount(scanner));
        bookstore.setGoods(new Goodsable[getQantityOfGoods(scanner)]);
        //TODO доделать имя цену и количество товаров
        System.out.println("Магазин: " + bookstore.getNameBookstore() + " Стартовый баланс магазина: " + bookstore.getCashAmount() +
                " Количество позиций на складе:" + bookstore.getGoods().length + " Успешно создан!");
        return bookstore;
    }

    /**
     * The method that creates the name of the store
     */
    private String getNameStore(Scanner scanner) {
        while (true) {
            System.out.println("Здравствуйте! Введите имя магазина");
            if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }

    /**
     * The method that sets the starting balance of the store
     * @param scanner
     * @return
     */
    private Double getCashAmount(Scanner scanner) {
        while (true) {
            System.out.println("Введите стартовый баланс:");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
        }
    }

    /**
     * The method that specifies the size of the warehouse
     * @param scanner
     * @return
     */
    private Integer getQantityOfGoods(Scanner scanner) {
        while (true) {
            System.out.println("Введите размер склада:");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
        }
    }

    /**
     * The method that selects the type of goods
     *
     * @param scanner
     * @return
     */
    public GoodsType typeGoods(Scanner scanner) {
        while (true) {
            System.out.println("Выберите тип товара!");
            System.out.println("Что бы выбрать книги, введите: " + GoodsType.BOOK.getValueName() + " Что бы выбрать газеты, ведите:" +
                    GoodsType.NEWSPAPER.getValueName() + " Что бы выбрать журналы, введите: " + GoodsType.MAGAZINES.getValueName());
            if (scanner.hasNext()) {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("Вы выбрали раздел: " + GoodsType.BOOK);
                        createBook(scanner);
                        return GoodsType.BOOK;
                    case 2:
                        System.out.println("Вы выбрали раздел: " + GoodsType.NEWSPAPER);
                        createNewspaper(scanner);
                        return GoodsType.NEWSPAPER;
                    case 3:
                        System.out.println("Вы выбрали раздел: " + GoodsType.MAGAZINES);
                        createMagazines(scanner);
                        return GoodsType.MAGAZINES;
                }
            }
        }
    }

    /**
     * Methods for creating products
     */
    private Book createBook(Scanner scanner) {
        Book book = new Book();
        System.out.println("Давайте теперь создадим выбранный товар!");
        book.setName(getGoodsName(scanner));
        book.setPrice(getGoodsPrice(scanner));
        return book;
    }

    private Newspapers createNewspaper(Scanner scanner) {
        Newspapers newspapers = new Newspapers();
        System.out.println("Давайте теперь создадим выбранный товар!");
        newspapers.setName(getGoodsName(scanner));
        newspapers.setPrice(getGoodsPrice(scanner));
        return newspapers;
    }

    private Magazines createMagazines(Scanner scanner) {
        Magazines magazines = new Magazines();
        System.out.println("Давайте теперь создадим выбранный товар!");
        magazines.setName(getGoodsName(scanner));
        magazines.setPrice(getGoodsPrice(scanner));
        return magazines;
    }

    /**
     * Methods that specify the name and price of goods
     *
     * @param scanner
     * @return
     */
    private String getGoodsName(Scanner scanner) {
        while (true) {
            System.out.println("Введите имя товара: ");
            if (scanner.hasNext()) {
                return scanner.next();
            }
        }
    }

    private Double getGoodsPrice(Scanner scanner) {
        while (true) {
            System.out.println("Введите цену товара: ");
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            }
        }
    }
}
