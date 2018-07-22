package com.lessons;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        //Here we clear the file before starting the program
        ThreadHelper.clearFile();

        //Created interface the ExecutorService the which started three threads
        ExecutorService executor = Executors.newWorkStealingPool(3);

        //Here I created a list with a Callable interface where I put three actions
        List<Callable<String>> callable = Arrays.asList(
                () -> {
                    String nameThread = Thread.currentThread().getName();
                    Long timeThread = System.nanoTime();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("First thread name: " + nameThread + " Time thread: " + timeThread);
                    return null;
                },

                () -> {
                    ThreadHelper.recordFile();
                    TimeUnit.SECONDS.sleep(1);
                    return null;
                },

                ()-> {
                    String message = null;
                    Integer value;
                    Integer a = 1, b = 1;
                    for (int i = 2; i < 8; i++) {
                        value = a + b;
                        System.out.println(value + " ");
                        b = b + a;
                        a = b - a;
                        TimeUnit.SECONDS.sleep(1);
                        message = value.toString();
                        ThreadHelper.writeFibonacci(message);
                    }
                    return message;
                });
        //Here I created a list with the Future interface that has an invokeAll method to run ExecutorService
        List<Future<String>> futures = executor.invokeAll(callable);
        executor.invokeAll(callable)
                .stream()
                .map(future-> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                })
                .forEach(System.out::println);
    }
}
