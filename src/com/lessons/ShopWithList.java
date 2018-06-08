package com.lessons;

import java.util.Scanner;

/**
 This class describe shop behavour
 */
public class ShopWithList {

    /**
     assort conteins list of goods wich we have in our shop
     */
    private com.lessons.MyList assort = new com.lessons.MyList();

    /**
     money is current cash in the shop
     */
    private double money;

    /**
     curPos save count of goods in our shop
     */
    private int curPos = 0;

    /**
     constructor set main settings our shop
     */
    ShopWithList(double mon) {
        money = mon;

    }

    /**
     this method print list of goods wich we hve in the shop
     */
    public void listGoods() {

            assort.getList();
          }

    /**
     This method add good in our shop
     */
    public void addGoods() {

        Scanner na = new Scanner(System.in);
        Scanner pr = new Scanner(System.in);
        Scanner co = new Scanner(System.in);
        Scanner ans1 = new Scanner(System.in);


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
                    assort.add(new Car(n, p, c));
                    break;
                case 2:
                    assort.add(new Butter(n, p, c));
                    break;
                case 3:
                    assort.add(new TShirt(n, p, c));
                    break;

            }

            money -= c;

    }

    /**
     This method delete good in our shop
     */
    public void byeGoods(com.lessons.Buyer buy) {

        Scanner ans1 = new Scanner(System.in);
        if (assort.size()==0) {
            System.out.println("We don`t have goods for selling");
        }
        else {

            System.out.println("Choise you good");
            assort.getList();

            Scanner s = new Scanner(System.in);

            int idx = s.nextInt();

            com.lessons.Goods ts = (com.lessons.Goods)assort.get(idx-1);

            if(buy.isCasheEnought(ts.getPrice())||buy.getPlace()){
                System.out.println("You can`t buy this goods.");
            }
            else{
                money += ts.getPrice();
                buy.buyGoods(ts);
                assort.remove(idx-1);
            }
        }
    }
}