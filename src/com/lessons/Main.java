package com.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What you would like to do with the entered numbers? ");
            System.out.println("If you want to add number, type'" + SortCommands.ADD_NUMBER.getCommandName() + "'");
            System.out.println("If you want to sort descending, type'" + SortCommands.SORT_DESCENDING.getCommandName() + "'");
            System.out.println("If you want to sort ascending, type'" + SortCommands.SORT_ASCENDING.getCommandName() + "'");
            System.out.println("If you want to clear list, type'" + SortCommands.CLEAR_LIST.getCommandName() + "'");
            System.out.println("If you want to close application, type '" + SortCommands.QUIT.getCommandName() + "'");

            if (scanner.hasNext() && scanner.next().equals(SortCommands.QUIT.getCommandName())) {
                return;

            }
        }
    }
}