package com.util;

import java.util.Scanner;

/**
 * Include method for show in console
 */
public class ConsoleReader {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Get number from console
     * @return Double or Integer number, 5 if incorrect value and null if input 'q'
     */
    public static Number getNumbersFromConsole() {
        System.out.println("next digit:");
        String input = scanner.nextLine();

        if(input.equals(ConsoleComand.Q.getConsoleIterpritate()))
            return null;

        Number number;

        try {
            if(input.contains("."))
                number = Double.valueOf(input);
            else
                number = Integer.valueOf(input);

        }catch (NumberFormatException nfe) {

            //default namber = 5;
            number = 5;
        }

        return number;
    }

}
