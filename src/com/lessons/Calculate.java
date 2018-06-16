package src.com.lessons;

import java.util.Scanner;

public class Calculate {
    /**
     * Calculating the Fibonacci number
     */
    public void printFibNumb(Long fib) {
        // algorithm
        long a = 1, b = 1;
        while (a <= fib){
            System.out.print(a + " ");
            b = b + a;
            a = b - a;
        }
        System.out.println();
    }
    public void checkInput(){
        Scanner scan = new Scanner(System.in);
        String fibs;
        System.out.println("Введите число до которого необходимо отобразить последовательность: ");
        System.out.println("для завершения работы нажмите \"q\" ");
        while (!(fibs = scan.next()).equals("q")){
            //wait for the input "q"
            Long fib = Long.parseLong(fibs);
            printFibNumb(fib);
            System.out.println("Введите число: ");

        }
        System.out.println("Заходьте ще ... ");
        scan.close();
    }
}
