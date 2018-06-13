package com.lessons;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private static workWithArray newArray = new workWithArray();




public static void interactionWithUser(){
    //workWithArray newArray = new workWithArray();
    System.out.println("To add new number to array enter 1");
    System.out.println("To sort array in asc order enter 2");
    System.out.println("To sort array in desc order enter 3");
    System.out.println("To clear array enter 4");
    System.out.println("To exit enter 5");
    String result = fromCode();
    if(result.equals("addNumber")){
        System.out.println("Add integer number");
        Scanner input1 = new Scanner(System.in);
        Integer newNum = input1.nextInt();
        newArray.addNumber(newNum);
        interactionWithUser();
    } else if(result.equals("ascOrder")){
        newArray.sortInAsc();
        newArray.show();
        interactionWithUser();

    } else if (result.equals("descOrder")){
        newArray.sortInDesc();
        newArray.show();
        interactionWithUser();

    } else if (result.equals("clear")){
        newArray.clear();
        interactionWithUser();

    } else if (result.equals("exit")){
        System.out.println("Good Bye");
    } else {
        System.out.println("Try again!");
        interactionWithUser();
    }



}

public static String fromCode(){
    Scanner input = new Scanner(System.in);
    Integer choose = input.nextInt();
        for (Commands com : Commands.values()) {
            if (choose.equals(com.getCode())) {
                //System.out.println(com.toString());
                return com.toString();
            }
        } return null;
}


}
