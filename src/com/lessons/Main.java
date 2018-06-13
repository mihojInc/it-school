package com.lessons;

import com.lessons.sort.MyList;
import com.lessons.util.ConsoleReader;
import com.lessons.util.SortDigitArray;

/**
 * Represent sort array of numbers
 */
public class Main {

    public static void main(String[] args) {
        MyList<Number> numberMyList = ConsoleReader.getNumbersFromConsole();

        System.out.println("You input:");
        for (int i = 0; i < numberMyList.size(); i++)
            System.out.print(numberMyList.get(i) + " ");

        numberMyList = SortDigitArray.sort(numberMyList);

        System.out.println("\nAfter sorted: ");
        for (int i = 0; i < numberMyList.size(); i++)
            System.out.print(numberMyList.get(i) + " ");
    }
}
