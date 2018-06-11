package com.lessons;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortingNumbers {

    /**
     * The method that asks what you want to do with the number
     * @param scanner
     */
    public void inputNumbers(Scanner scanner) {
        while (true) {
            conditionForTheJob();
            if (scanner.hasNext()) {
                CommandsForSortingNumbers command = CommandsForSortingNumbers.getCommand(scanner.next());
                if (command == null) {
                    continue;
                }
                switch (command) {
                    case SORT_ASCENDING: {
                        sortAscending(scanner);
                        System.out.println(" ");
                        break;
                    }
                    case SORT_DECREASING: {
                        sortDecreasing(scanner);
                        System.out.println(" ");
                        break;
                    }
                    case QUIT:
                        finishProgramm();
                        return;
                    default:
                        continue;
                }
            }
        }
    }

    /**
     * Create the method Condition for the job
     */
    public void conditionForTheJob() {
        System.out.println("Hello! What do you want to do with the number!");
        System.out.println("If you want to sort the number in ascending order, enter: " + CommandsForSortingNumbers.SORT_ASCENDING.getCommandName());
        System.out.println("If you want to sort the number in descending order, enter: " + CommandsForSortingNumbers.SORT_DECREASING.getCommandName());
        System.out.println("If you want to quit, enter: " + CommandsForSortingNumbers.QUIT.getCommandName());
    }

    /**
     * The method that sorts numbers in ascending order
     * @param scanner
     */
    public void sortAscending(Scanner scanner) {
        System.out.println("Введите размер массива!");
        int value = scanner.nextInt();
        int[] array = new int[value];
        System.out.println("Введите числа по размеру массива в разброс!");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
//            for (int j = 0; j < i; j++) {
//                if (array[j] > array[j + 1]) {
//                    int tmp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = tmp;
//                }
//            }

        }
        Arrays.sort(array);
        System.out.println("Список отсортирован по возрастанию!");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * The method that sorts numbers in descending order
     */
    public void sortDecreasing(Scanner scanner) {
        System.out.println("Введите размер массива!");
        int value = scanner.nextInt();
        Integer[] array = new Integer[value];
        System.out.println("Введите числа по размеру массива в разброс!");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("Список отсортирован по убыванию!");
        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }

    /**
     * Farewell method
     */
    public void finishProgramm() {
        System.out.println("Good buy!");
    }
}
