package com.lessons;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App7 {

    Callable<String> getCallabe(String result, long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        App7 app = new App7();
        ExecutorService executor = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                app.getCallabe("task1", 2),
                app.getCallabe("task2", 1),
                app.getCallabe("task3", 3));

        String result = executor.invokeAny(callables);
        System.out.println(result);

    }
}
