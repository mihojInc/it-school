package com.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class describes the main actions that can be performed with the array of numbers, such as: add to array, sort (descending and ascending order),
 * clear array, complete the program. All numbers are entered using scanner, there is no set size of the array.
 */
public class NumbersManager {
    List<Integer> numberList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    /**
     * Method describes entering numbers in the array using scanner and adding these numbers into array.
     */
    public void setupNumbers() {
        System.out.println("Hello, enter your numbers with spaces: ");
        while (scanner.hasNextInt()) {
            numberList.add(scanner.nextInt());
        }
        chooseOption();
    }

    /**
     * Method describes how to sort numbers in the array in descending order.
     */
    private void showNumbersDescending() {
        System.out.println("Descending sorting: ");
        Collections.sort(numberList, Collections.reverseOrder());
        for (int i = 0; i < numberList.size(); i++) {
            System.out.println(numberList.get(i));
        }
    }

    /**
     * Method describes how to sort numbers in the array in ascending order.
     */
    private void showNumbersAscending() {
        System.out.println("Ascending sorting: ");
        Collections.sort(numberList, Collections.reverseOrder());
        Collections.reverse(numberList);
        for (int i = 0; i < numberList.size(); i++) {
            System.out.println(numberList.get(i));
        }
    }

    /**
     * Method describes how to clear array, if it contains any numbers.
     */
    private void clearList() {
        if (numberList.size() != 0) {
            numberList = new ArrayList<>();
            System.out.println("This list if cleared");
        } else {
            System.out.println("List is 0");
        }
    }

    /**
     * Method describes how to finish working with numbers in array.
     */
    private void finishProgramm() {
        System.out.println("Good bye");
    }

    /**
     * Method for working with enum of commands.
     */
    private void chooseOption() {
        while (true) {
            System.out.println("What you would like to do with the entered numbers? ");
            System.out.println("If you want to sort descending, type'" + SortCommands.SORT_DESCENDING.getCommandName() + "'");
            System.out.println("If you want to sort ascending, type'" + SortCommands.SORT_ASCENDING.getCommandName() + "'");
            System.out.println("If you want to clear list, type'" + SortCommands.CLEAR_LIST.getCommandName() + "'");
            System.out.println("If you want to close application, type '" + SortCommands.QUIT.getCommandName() + "'");

            if (scanner.hasNext() && scanner.next().equals(SortCommands.SORT_DESCENDING.getCommandName())) {
                showNumbersDescending();
            }
            if (scanner.hasNext() && scanner.next().equals(SortCommands.SORT_ASCENDING.getCommandName())) {
                showNumbersAscending();
            }
            if (scanner.hasNext() && scanner.next().equals(SortCommands.CLEAR_LIST.getCommandName())) {
                clearList();
            }
            if (scanner.hasNext() && scanner.next().equals(SortCommands.QUIT.getCommandName())) {
                finishProgramm();
                return;
            }
        }
    }
}
