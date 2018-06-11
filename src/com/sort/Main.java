package com.sort;

import com.util.ConsoleReader;
import com.util.SortDigitArray;

/**
 * Sort array of digit in console
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Input digits for sort them. 'q' for quit" + 4.0 % 1);
        MyList<Number> numberMyList = new MyList<>();

        Number number;
        do {
            number = ConsoleReader.getNumbersFromConsole();
            if(number != null)
                numberMyList.add(number);

        }while (number != null);

        System.out.println("You input: ");
        for (int i = 0; i < numberMyList.size(); i++)
            System.out.print(" " + numberMyList.get(i));

        numberMyList = SortDigitArray.sort(numberMyList);
        System.out.println("\nAfter sorted: ");
        for (int i = 0; i < numberMyList.size(); i++)
            System.out.print(" " + numberMyList.get(i));

    }
}
