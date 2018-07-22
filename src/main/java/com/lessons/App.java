package com.lessons;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class App {
    public static void main(String[] args) throws Exception {
        Long fib;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " " + dateFormat.format(date));
                    return "";
                },
                () -> {
                    FileWriter file = new FileWriter("C:\\Users\\master\\IdeaProjects\\it-school_classShedul\\src\\main\\java\\com\\lessons\\resultfile.txt");
                    file.write(Thread.currentThread().getName());
                    file.write(" ");
                    file.write(dateFormat.format(date));
                    file.close();
                    return "";
                },
                () -> {printFibNumb(20l);
                return "";});


        List<Future<String>> resultList = executor.invokeAll(callables);


        resultList
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
        executor.shutdown();



        System.out.println("Complete");
    }
    public static void printFibNumb(Long fib) {
        // algorithm
        long a = 1, b = 1;
        while (a <= fib){
            System.out.print(a + " ");
            b = b + a;
            a = b - a;
        }
        System.out.println();
    }
}
