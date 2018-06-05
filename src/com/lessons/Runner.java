package com.lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class runner
 */
public class Runner {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string;
        System.out.println("ведите целочисленное значение до которого отобразить последовательность Фибоначчи: ");
        System.out.println("Или введите символ \"q\" что бы выйти из программы!");
        while (!(string = reader.readLine()).equals("q")) {
            long number=0;
            try {
                number = Long.parseLong(string);
                FunctionHelper.printFibonacciNumbers(number);
            } catch (NumberFormatException e) {
                System.out.println("enter only number or symbol 'q'");
            }
            System.out.println();
            System.out.println("Введите целочисленное значение до которого отобразить последовательность Фибоначчи: ");
            System.out.println("Или введите символ \"q\" что бы выйти из программы!");
        }
        reader.close();
        System.out.println("Спасибо за пользование приложением. До свидания.");

    }
}
