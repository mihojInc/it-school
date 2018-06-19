package com.lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * class with method for numbers
 */
public class NumberHelper {
    /**
     * list for numbers
     */
    private List<Integer> numbersList = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * method for select option from console
     */
    private void selectOption() throws IOException {
        while (true) {
            System.out.println("If you want to sort descending, type'" + Commands.SORT_DECREASING.getCommandName() + "'");
            System.out.println("If you want to sort ascending, type'" + Commands.SORT_ASCENDING.getCommandName() + "'");
            System.out.println("If you want to clear list, type'" + Commands.CLEAR_LIST.getCommandName() + "'");
            System.out.println("If you want to close application, type '" + Commands.QUIT.getCommandName() + "'");
            String text = reader.readLine();

            if (text.equals(Commands.SORT_DECREASING.getCommandName())) {
                sortDescending();
                showNumbers();
            } else {
                if (text.equals(Commands.SORT_ASCENDING.getCommandName())) {
                    sortAscending();
                    showNumbers();
                } else {
                    if (text.equals(Commands.CLEAR_LIST.getCommandName())) {
                        clearList();
                    } else {
                        if (text.equals(Commands.QUIT.getCommandName())) {
                            System.out.println("thank you for using the program");
                            return;
                        } else {
                            System.out.println("enter only command");
                        }
                    }
                }
            }
        }
    }

    /**
     * method for begin work and add numbers
     */
    public void beginWork() {
        System.out.println("enter number, if you end entering number enter 'esc'");
        String text;
        try {
            while (!(text = reader.readLine()).equals("esc")) {
                numbersList.add(Integer.parseInt(text));
            }
            selectOption();
        } catch (NumberFormatException e) {
            System.out.println("enter only number");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method for show numbers
     */
    private void showNumbers() {
        for (int number : numbersList) {
            System.out.println(number);
        }
    }

    /**
     * sort descending
     */
    private void sortDescending() {
        for (int i = 0; i < numbersList.size() - 1; i++) {
            for (int j = i + 1; j < numbersList.size(); j++) {
                if (numbersList.get(i) < numbersList.get(j)) {
                    changeNumbers(i, j);
                }
            }
        }
    }

    /**
     * sort ascending
     */
    private void sortAscending() {
        for (int i = 0; i < numbersList.size() - 1; i++) {
            for (int j = i + 1; j < numbersList.size(); j++) {
                if (numbersList.get(i) > numbersList.get(j)) {
                    changeNumbers(i, j);
                }
            }
        }
    }

    /**
     * method for change numbers
     */
    private void changeNumbers(int i, int j) {
        int temp = numbersList.get(i);
        numbersList.add(i, numbersList.get(j));
        numbersList.add(j, temp);
        numbersList.remove(i + 1);
        numbersList.remove(j + 1);
    }

    /**
     * method for clearing list
     */
    private void clearList() {
        if (numbersList.size() != 0) {
            numbersList = new ArrayList<>();
            System.out.println("list clear");
        } else {
            System.out.println("list is already clear");
        }
    }
}
