package com.lessons;


import java.util.Scanner;

/**
 * Create class Bookstore
 */
public class Bookstore {
    private String nameBookstore;//Имя магазина
    private Goodsable[] goods;   //Массив товаров
    private Double cashAmount;  //Размер кассы
    private Integer qantityOfGoods = 0; //Количества товаров

    //Constructor
//    public Bookstore(String nameBookstore, Double cashAmount, Integer goodsSize) {
//        this.nameBookstore = nameBookstore;
//        this.cashAmount = cashAmount;
//        this.qantityOfGoods = 0;
//        this.goods = new Goodsable[goodsSize];
//
//    }

    //Getters and Setters
    public String getNameBookstore() {
        return nameBookstore;
    }

    public void setNameBookstore(String nameBookstore) {
        this.nameBookstore = nameBookstore;
    }

    public Goodsable[] getGoods() {
        return goods;
    }

    public void setGoods(Goodsable[] goods) {
        this.goods = goods;
    }

    public Double getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public Integer getQantityOfGoods() {
        return qantityOfGoods;
    }

    public void setQantityOfGoods(Integer qantityOfGoods) {
        this.qantityOfGoods = qantityOfGoods;
    }

    /**
     * The method that displays the name of the store
     */
    public void displayBookstoreName() {
        System.out.println("Добро пожаловать в магазин книг: " + nameBookstore);
    }

    /**
     * The method that displays a list of books
     */
    public void showListGoods() {
        System.out.println("Список товара!");
        for (int i = 0; i < goods.length; i++) {
            if (goods[i] != null) {
                System.out.println("Имя товара" + goods[i].getName() + "Цена" + goods[i].getPrice());
            }
            break;
        }

    }

    /**
     * The method that buys the goods
     */
    public void buyGoods(Goodsable good) {
        if (cashAmount < good.getPrice()) {
            System.out.println("Деньги в магазине закончились!");
        }

        if (qantityOfGoods < goods.length) {
            for (int i = 0; i < goods.length; i++) {
                if(goods[i] == null){
                    goods[i] = good;
                }
            }
            cashAmount -= good.getPrice();
            ++qantityOfGoods;
            System.out.println("Имя товара: " + good.getName() + " цена: " + good.getPrice() + " добавлено!");
            System.out.println("Общий баланс: " + cashAmount + " \n Количество товаров: " + qantityOfGoods);
        } else {
            System.out.println("Нет места для вашего товара.");
        }
    }

    /**
     * The method that sells the goods
     */
    public void sellGoods(Goodsable good) {
        boolean flag = false;
        if (qantityOfGoods < goods.length) {
            goods[qantityOfGoods] = good;
            for (int i = 0; i < goods.length; i++) {
                if (goods[i] != null && goods[i].equals(good)) {
//                    System.out.println("Продан товар " + good.getName());
                    goods[i] = null;
                    flag = true;
                }
            }
            if (flag) {
                cashAmount += good.getPrice();
                qantityOfGoods -= 1;
                System.out.println("Имя товара: " + good.getName() + " цена: " + good.getPrice() + " продано!");
                System.out.println("Общий баланс: " + cashAmount + " \n Количество товаров: " + qantityOfGoods);
            } else {
                System.out.println(" Данный товар не найден на складе");
            }


        } else {
            System.out.println("Нет места для вашего товара.");
        }
    }
}

