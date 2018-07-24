package com.lessons;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadService {
    File fileWithLinks = new File("./src/main/java/com/lessons/links");
    Scanner scan = new Scanner(System.in);
    Interaction interaction = new Interaction();

    public void downloadFromFile(Integer count){
        AtomicInteger innerCount = new AtomicInteger(1);
        String link = "";
        ExecutorService es = Executors.newFixedThreadPool(count);
        List<Future> listFutures = new LinkedList<>();

        List<CallableImageLoader> list = new LinkedList<>();

        while (innerCount.get()<=count){
            link = FileUtil.readString(fileWithLinks,innerCount.get());
            list.add(new CallableImageLoader(innerCount.get(), link));
            innerCount.getAndIncrement();
        }

        list.stream().forEach((a) -> es.submit(a));

        for (Future future: listFutures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
    }

    public void downloadFromConsole(Integer count){
        AtomicInteger innerCount = new AtomicInteger(1);
        String link = "";
        ExecutorService es = Executors.newFixedThreadPool(count);
        List<Future> listFutures = new LinkedList<>();

        List<CallableImageLoader> list = new LinkedList<>();

        while (innerCount.get()<=count){
            StringBuffer sb = new StringBuffer(interaction.printLink(scan));
            link = sb.insert(0,"https://").toString();
            list.add(new CallableImageLoader(innerCount.get(), link));
            innerCount.getAndIncrement();
        }

        list.stream().forEach((a) -> es.submit(a));

        for (Future future: listFutures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
    }

}
