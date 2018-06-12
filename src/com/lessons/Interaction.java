package com.lessons;
import java.util.Scanner;

public class Interaction {
    WorkWithArray arr;

    public Interaction(WorkWithArray arr) {
        this.arr = arr;
    }

    public void mainChoice(){
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "- " +
                Commands.ADD.getMessage() + "- " +
                Commands.SORT_TO_MAX.getMessage() + "- " +
                Commands.SORT_TO_MIN.getMessage() + "- " +
                Commands.CLEAR.getMessage() + "- " +
                Commands.EXIT.getMessage()
        );

        String checkStr = scan.nextLine();
        if(checkStr.equals(Commands.ADD.getCommand())){
            arr.addNumber();
            mainChoice();
        }else if (checkStr.equals(Commands.SORT_TO_MAX.getCommand())){
            arr.showSortToMax();
            mainChoice();
        }else if (checkStr.equals(Commands.SORT_TO_MIN.getCommand())){
            arr.showSortToMin();
            mainChoice();
        }else if (checkStr.equals(Commands.CLEAR.getCommand())){
            arr.clear();
            mainChoice();
        }else if (checkStr.equals(Commands.EXIT.getCommand())){
            return;
        }else{
            System.out.print(Messages.ERROR);
            mainChoice();
        }
    }
}
