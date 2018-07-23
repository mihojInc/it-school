package com.lessons;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class App {

    public final static String SECONDTASK = "../it-school/src/main/java/com/lessons/second-task.txt";
    public final static String REPORT = "../it-school/src/main/java/com/lessons/report.txt";
    public static final long STARTTIME = new Date().getTime();

    public static void main(String[] args) {
        System.out.println("Application represent execution task for miliseconds");

        ExecutorService service = Executors.newWorkStealingPool(4);
        Tasks tasks = new Tasks();

        List<Runnable> runnables = Arrays.asList(
                () -> {
                    String threadTime = tasks.threadNameAndTime();
                    System.out.println(threadTime);
                    tasks.writeInFile(threadTime, REPORT, true);
                },
                () -> {
                    String threadTime = tasks.threadNameAndTime();
                    tasks.writeInFile(threadTime, SECONDTASK, false);
                    tasks.writeInFile(threadTime, REPORT, true);
                }
        );

        List<Callable<Integer>> callable = Arrays.asList(
                Executors.callable(runnables.get(0), 0),
                Executors.callable(runnables.get(1), 0),
                () -> tasks.fibonachiCount(20)
        );

        try {
            service.invokeAll(callable).stream().mapToInt(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            })
                    .forEach(value -> {
                        if (value != 0) {
                            String toReport = value + " -> " + (new Date().getTime() - STARTTIME) + " ms";
                            System.out.println(toReport);
                            Tasks.writeInFile(toReport, REPORT, true);
                        }
                    });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}