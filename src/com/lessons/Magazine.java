package com.lessons;

import java.util.Scanner;

public class Magazine {
    private Item warehouse[];
    private double money;
    private int onWarehouse = 0;
    private double extraCharge;

    /**
     * it's constructor for creating shop
     * @param powerOfWarehouse - storage capacity
     * @param startSum - the initial amount of money in the box office
     */
    Magazine(int powerOfWarehouse, double startSum, double extraCharge) {
        this.warehouse = new Item[powerOfWarehouse];
        this.money = startSum;
        this.extraCharge = extraCharge;
    }

    /**
     * method for adding new items in warehouse
     * @param newItem - new item
     */
    public void addItem(Item newItem) {
        if (onWarehouse < warehouse.length && money > newItem.getPrice()) {
            warehouse[onWarehouse] = newItem;
            money -= newItem.getPrice();
            onWarehouse++;
            // showWarehouse();
        } else
            System.out.println("Warehouse is overflow! or you don`t have enough money");

    }

    /**
     * method for buying item
     * @param wantedItem - item that I want to buy
     */
    public void buyItem(Buyer newBayer,Item wantedItem) {

        for (int i = 0; i < warehouse.length - 1; i++) {
            if (wantedItem.equals(warehouse[i])&& newBayer.getSum()>=wantedItem.getPrice() * (1+extraCharge) &&
                    newBayer.getInGroceryList()<newBayer.getGroceryList().length) {
                money += wantedItem.getPrice() * (1+extraCharge);
                double rest = newBayer.getSum();
                rest-=wantedItem.getPrice() * (1+extraCharge);
                newBayer.setSum(rest);
                warehouse[i] = null;
                newBayer.setGroceryList(wantedItem);
            }
            else {System.out.println("Something is wrong.Try again");

            }
        }
    }

    /**
     * method that shows the contents of the warehouse
     */
    public void showWarehouse() {
        System.out.println("-----------------------show warehouse------");
        for (int i = 0; i < warehouse.length; i++){
            if(warehouse[i]!=null){
                System.out.print(warehouse[i].getName() + " ");
            }
        }
        System.out.println();
    }

    /**
     * method that shows the current amount of money in the box office
     * @return - current amount of money
     */
    public void getMoney() {

        System.out.println(money);
    }

    public void  interactionWithUsers(){
        Scanner input = new Scanner(System.in);
        System.out.println("To create new item enter 'create'");
        System.out.println("To sell item enter 'sell'");
        System.out.println("To watch list of items enter 'show'");
        System.out.println("To watch cash enter 'cash'");
        System.out.println("To exit enter 'end'");
        String choice = input.nextLine();
        if(choice.equals("create")){
            System.out.println("create");
            System.out.println("Enter name of product");
            String name = input.nextLine();
            System.out.println("Enter price of product");
            String price1 = input.nextLine();
            double price = Double.valueOf(price1);
            System.out.println("If water enter w, if bread enter b, if sausage enter s");
            String choice1 = input.nextLine();
            if(choice1.equals("w")){
                Item water = new Water(name, price);
                addItem(water);
                interactionWithUsers();
            }
            if(choice1.equals("b")){
                Item bread = new Bread(name, price);
                addItem(bread);
                interactionWithUsers();
            }
            if(choice1.equals("s")){
                Item sausage = new Sausage(name, price);
                addItem(sausage);
                interactionWithUsers();
            }
            else {
                System.out.println("Try again");
                interactionWithUsers();
            }


        }

        if(choice.equals("sell")){
            System.out.println("sell");
            System.out.println("Enter name");
            String name = input.nextLine();
            System.out.println("Enter available sum");
            String sum1 = input.nextLine();
            double sum = Double.valueOf(sum1);

            String power1 = input.nextLine();
            int power = Integer.valueOf(power1);
            Buyer newBuyer = new Buyer(sum,power);
            System.out.println("Enter name of wanted product");
            String productName = input.nextLine();
            for(int i = 0; i<onWarehouse-1; i++) {
                if (productName.equals(warehouse[i].getName())){
                    buyItem(newBuyer,warehouse[i]);
                    break;
                }
            }
            interactionWithUsers();
        }
        if(choice.equals("show")){
            showWarehouse();
            interactionWithUsers();
        }
        if(choice.equals("cash")){
            getMoney();
            interactionWithUsers();
        }
        if(choice.equals("end")){
            System.out.println("Goodbye!");
        }
    }
}
