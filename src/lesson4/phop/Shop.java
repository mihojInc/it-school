package lesson4.phop;
import java.util.Scanner;
/* класс  модель магазина которая описывает параметры и методы магазина*/

public class Shop {

    private Item[] goods;
    private double balance;
    private Integer count;
    private String listGoods;


    Shop(Integer goodsSize, double balance) {
        goods = new Item[goodsSize];
        this.balance = balance;
        listGoods = " ";
        count = 0;
    }
/* метод закупки товара магазином*/

    public void buyGood(Item good) {
        if (balance < good.getPrice()) {
            System.out.println("Извените! У нас не хватает денег для покупки вашего товара");
            return;
        }
        if (count < goods.length) {
            goods[count] = good;
            balance = balance - good.getPrice();
            ++count;
            listGoods = listGoods + good.getName();
            System.out.println("Наименование товара: " + good.getName() + "    Цена : "
                    + good.getPrice() + "$ успешно добавлено");

            System.out.println("В Кассе: " + balance + "$     Количество товаров: " + count);
            System.out.println("                На складе :  " + listGoods);
            System.out.println();
        } else {
            System.out.println("Нет места для твоего товара");
        }

    }

    /* старый метод продажи товаров
     public void sellGood(Item good){
         if (count< goods.length ){
             goods[count]=good;
             balance = balance + good.getPrice();
             count = count -1;
             listGoods = good.getName();
             System.out.println("Наименование товара: " + good.getName() + "     Цена : " + good.getPrice() + "$ продан");
             System.out.println("В Кассе: " + balance + "$     Количество товаров: " + count);
         } else {
             System.out.println("Нет места для твоей позиции");
         }
     } */

   /* метод добавления товара в магазин через консоль*/
    public void buyProduct(Item good) {
        System.out.println("Введите название нового товара: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Введите цену нового товара: ");
        Scanner scn = new Scanner(System.in);
        double price = scn.nextDouble();

        if (balance < price) {
            System.out.println("Извените! У нас не хватает денег для покупки вашего товара");
            return;
        }
        if (count < goods.length) {
            goods[count] = good;
            balance = balance - price;
            ++count;
            listGoods = listGoods + name;
            System.out.println("Наименование товара: " + name + "    Цена : " + price + "$ успешно добавлено");
            System.out.println("В Кассе: " + balance + "$     Количество товаров: " + count);
            System.out.println("                На складе :  " + listGoods);
            System.out.println();
        }
    }
}

