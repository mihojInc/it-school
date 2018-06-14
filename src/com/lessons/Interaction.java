package com.lessons;
import java.util.Scanner;

public class Interaction {
    WorkWithArray arr;

    public Interaction(WorkWithArray arr) {
        this.arr = arr;
    }

    public void mainChoice(Scanner scan) {
        while (true) {
            for (Commands command: Commands.values()){
                System.out.println("- " + command.getMessage());
            }

            String checkStr = scan.nextLine();
            if (checkStr.equals(Commands.ADD.getCommand())) {
                arr.addNumber();
            } else if (checkStr.equals(Commands.SORT_TO_MAX.getCommand())) {
                arr.showSortToMax();
            } else if (checkStr.equals(Commands.SORT_TO_MIN.getCommand())) {
                arr.showSortToMin();
            } else if (checkStr.equals(Commands.CLEAR.getCommand())) {
                arr.clear();
            } else if (checkStr.equals(Commands.EXIT.getCommand())) {
                return;
            } else {
                System.out.print(Messages.ERROR.getMessage());
            }
        }
    }
}
