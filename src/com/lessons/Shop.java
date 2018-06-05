package com.lessons;

import java.util.Scanner;

/*
   This class describe shop behavour
 */
public class Shop {

    /*
    assort conteins list of goods wich we have in our shop
     */
    private Goods[] assort;

    /*
    money is current cash in the shop
     */
    private double money;

    /*
    curPos save count of goods in our shop
     */
    private int curPos = 0;

    /*
    this method print list of goods wich we hve in the shop
     */
    public void listGoods() {

        System.out.println("List of goods");
        if (curPos != 0) {
            for (Goods s : assort) {
                if (s != null) {
                    System.out.println(s.getName() + " price:" + s.getPrice() + " cost: " + s.getCost());
                }
            }

        } else {
            System.out.println("We don`t have goods");
        }

        System.out.println("Cash " + money);
    }

    /*
     This method add good in our shop
    */
    public void addGoods() {

        Scanner na = new Scanner(System.in);
        Scanner pr = new Scanner(System.in);
        Scanner co = new Scanner(System.in);
        Scanner ans1 = new Scanner(System.in);

        if (curPos == assort.length) {
            System.out.println("Sorry you can`t add new goods");
        } else {

            System.out.println("What kind of do you want to add");
            System.out.println("1 Car");
            System.out.println("2 Butter");
            System.out.println("3 TShirt");

            int ans = ans1.nextInt();

            System.out.println("Enter name");
            String n = na.nextLine();
            System.out.println("Enter price");
            double p = pr.nextDouble();
            System.out.println("Enter cost");
            double c = co.nextDouble();

            if (money < c) {
                System.out.println("We have no enought money for buy it");
                return;
            }

            switch (ans) {
                case 1:
                    assort[curPos++] = new Car(n, p, c);
                    break;
                case 2:
                    assort[curPos++] = new Butter(n, p, c);
                    break;
                case 3:
                    assort[curPos++] = new TShirt(n, p, c);
                    break;

            }

            money -= c;
        }
    }

    /*
      This method delete good in our shop
    */
    public void byeGoods(com.lessons.Buyer buy) {

        Scanner ans1 = new Scanner(System.in);
        if (curPos == 0) {
            System.out.println("We don`t have goods for selling");
        } else {

            if(buy.getHaveCash()<assort[curPos - 1].getPrice()||buy.getPlace()){
                System.out.println("You can`t buy this goods.");
            }
            else{
                listGoods();
                money += assort[curPos - 1].getPrice();
                assort[--curPos] = null;
            }
        }
    }

    /*
      constructor set main settings our shop
    */
    Shop(int countGoods, double mon) {
        assort = new Goods[countGoods];
        money = mon;

    }
}