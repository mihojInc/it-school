package com.lessons;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadService {

    public static void download(List<String> downloadLinks){
        AtomicInteger counter = new AtomicInteger(1);
        ExecutorService executorService = Executors.newFixedThreadPool(downloadLinks.size()+1);
        List<Future<String>> listFutures = new LinkedList<>();
        List<Callable<String>> links = new LinkedList<>();
        List<String> downIm = new LinkedList<>();

        while (counter.get()<= downloadLinks.size()){
            links.add(new CallableImageLoader(counter.get(), downloadLinks.get(counter.get()-1)));
            counter.getAndIncrement();
        }

        links.stream().forEach((a) -> executorService.submit(a));

        /*for (Future future: listFutures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/
        executorService.shutdown();



    }

}
