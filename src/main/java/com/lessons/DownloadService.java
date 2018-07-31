package com.lessons;

import java.io.File;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadService {
    private File fileWithLinks = new File("./src/main/java/com/lessons/links");
    private Scanner scan = new Scanner(System.in);
    private Interaction interaction = new Interaction();
    private static CopyOnWriteArrayList<String> logList = new CopyOnWriteArrayList<>();


    public void downloadImages(Integer count, Integer downloadType){
        AtomicInteger innerCount = new AtomicInteger(1);
        String link = "";
        ExecutorService es = Executors.newFixedThreadPool(count);
        List<Future> listFutures = new LinkedList<>();

        List<CallableImageLoader> list = new LinkedList<>();

        while (innerCount.get()<=count){
            if(downloadType == 2){
                link = interaction.printLink(scan);
            }else if(downloadType == 1){
                link = FileUtil.readString(fileWithLinks,innerCount.get());
            }
            list.add(new CallableImageLoader(innerCount.get(), link));
            innerCount.getAndIncrement();
        }

       list.stream().forEach((a) -> {
           try {
               logList.add(es.submit(a).get());
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           }
       });
        es.shutdown();
    }

    public static CopyOnWriteArrayList<String> getLogList() {
        return logList;
    }

}
