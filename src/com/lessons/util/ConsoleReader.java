package com.lessons.util;

import com.lessons.sort.MyList;

import java.util.Scanner;

/**
 * Include method for show in console
 */
public class ConsoleReader {

    static Scanner scanner = new Scanner(System.in);

    /**
     * @return Inputed MyList<Number> from console
     */
    public static MyList<Number> getNumbersFromConsole() {
        System.out.println("Input digits for sort them. 'q' for quit");

        MyList<Number> numberMyList = new MyList<>();

        Number number;
        String readString = "";

        while (!readString.equals(ConsoleCommand.Q.getConsoleInterpritate())) {

            System.out.println("next digit:");
            readString = scanner.nextLine();

            if(!readString.equals(ConsoleCommand.Q.getConsoleInterpritate()))
            //check correct input
            try {

                //check double value
                if (readString.contains("." )) {
                    number = Double.valueOf(readString);
                } else {
                    number = Integer.valueOf(readString);
                }

                numberMyList.add(number);
            } catch (NumberFormatException nfe) {

                System.out.println("Please input correct value.");
            }
        }

        return numberMyList;
    }

}
