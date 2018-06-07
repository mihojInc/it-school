package com.lessons.Fibonacci;

import java.util.Scanner;
/**
 * Create a class that counts the Fibonacci number
 */
public class FunctionHelper {
    /**
     * Calculating the Fibonacci number
     *
     * @param value
     */
    public void printFibonacciNumbers(Long value) {
        long a = 1, b = 1;
        while (a <= value) {
            System.out.println(a + " ");
            b = b + a;
            a = b - a;
        }
    }

    /**
     * Checking for the correctness of entering a number and a symbol
     */
    public void method() {
        Scanner scanner = new Scanner(System.in);
        //Create a variable String for exiting their program
        String string;
        System.out.println("Введите целочисленное значение до которого отобразить последовательность Фибоначчи: ");
        System.out.println("Или введите символ \"q\" что бы выйти из программы!");
        //Тут читаем со сканера строку, если она не заданный символ "q"
        //То мы передаем значение в переменную Long value
        //А еще эта штука кидает Exception NumberFormatException
        //Если ввести не заданный символ
        while (!(string = scanner.next()).equals("q")) {
            //Если не символ, передаем значение в переменную
            //И парсим строку в число типа Long
            Long value = Long.parseLong(string);
            printFibonacciNumbers(value);
            System.out.println("Введите целочисленное значение до которого отобразить последовательность Фибоначчи: ");
            System.out.println("Или введите символ \"q\" что бы выйти из программы!");
        }
        System.out.println("Спасибо за пользование приложением. До свидания.");
        scanner.close();
    }
}
