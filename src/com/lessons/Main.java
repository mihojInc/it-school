package com.lessons;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //Crearte new scanner for save answer of choise and shop settings
        Scanner ans1 = new Scanner(System.in);
        Scanner cons = new Scanner(System.in);
        String ans;

        //ask question and set settings of the shop
        System.out.println("What count of doods do we have: ");
        int countGoods = cons.nextInt();
        System.out.println("How much money do we have in cash: ");
        double mon = cons.nextDouble();

        //create new shop and send main settings in constructor
        Shop shop = new Shop(countGoods, mon);

        //ask question and set settings of the Buyer
        System.out.println("What size of your bag: ");
        countGoods = cons.nextInt();
        System.out.println("How much money do you have: ");
        mon = cons.nextDouble();

        com.lessons.Buyer buy = new com.lessons.Buyer(mon, countGoods);


        //this loop will execute while we don`t press q
        do {
            //asq about our action
            System.out.println("What will we do? \nAdd goods (a) \nBye good (b) \nGet list (g) \nQuit (q)");

            //read answer
            ans = ans1.nextLine();

            switch (ans) {
                case "a":
                    //if we press a we add googs
                    shop.addGoods();
                    break;
                case "b":
                    //if we press b we bye googs
                    shop.byeGoods(buy);
                    break;
                case "g":
                    //if we press a we print list of goods
                    shop.listGoods();
                    break;
                case "q":
                    //if we press a we quit
                    System.out.println("Good bye");
                    break;
                default:
                    //if we press something else we print message about incorrect enter
                    System.out.println("Your choise is incorrect");
            }

        } while (ans != "q");

    }
}
