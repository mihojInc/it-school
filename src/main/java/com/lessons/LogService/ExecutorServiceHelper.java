package com.lessons.LogService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceHelper {

    public static void downloadImagesFromFile() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future> futureList = new LinkedList<>();
        Integer counter = 0;

        List<String> paths = FileManager.readFile();

        for (String path : paths) {
            futureList.add(executor.submit(new CallableImagesLoader(++counter, path)));
        }

        for (Future future : futureList) {
            try {
                System.out.println(future.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     executor.shutdown();
    }
}
