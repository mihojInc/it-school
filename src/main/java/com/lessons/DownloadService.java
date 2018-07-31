package com.lessons;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.io.IOException;

/**
 * Класс реализовывает механизмы загрузки из файла в котором список ссылок, и каждый файл отдельно
 */
public class DownloadService {

    Scanner sc;
    /**
     * Файл в котором будет сохраняться логи
     */
    LogService log;

    public DownloadService(Scanner sc, LogService log) {
        this.sc = sc;
        this.log = log;
    }

    /**
     * В данной функции будет указан файл, в котором указан список ссыолок на файлы
     * @throws IOException
     */
    public void downloadFromFile()throws Exception {
        System.out.println("File path: ");

        sc.nextLine();
        String pathList = sc.nextLine();

        System.out.println("Enter count of images for downloading: ");
        int count;
        while(!sc.hasNextInt()){
            System.out.println("You enter wrong number");
            sc.next();
        }

        count = sc.nextInt();
        List<String> list = FileManager.readFile(pathList, count);
        executeLoad(list,count);
    }

    /**читаем файл по очереди
     *
     * @throws Exception
     */
    public void downloadOneByOne()throws Exception{
        System.out.println("Enter count of images for downloading: ");

        int count;
        while(!sc.hasNextInt()){
            System.out.println("You enter wrong number");
            sc.next();
        }

        count = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<count; i++){
            System.out.println("Enter next image: ");
            list.add(sc.nextLine());
        }
       executeLoad(list,count);
    }

    /**
     * Непосредственно процедура в который запускаются потоки
     * @param list
     * @param count
     */
    public void executeLoad(List<String> list, int count){
        ExecutorService service = Executors.newFixedThreadPool(count);

        //Получили список того что нам нужно затянуть из интернета и проходим по списку и делаем новый поток
        list.forEach((a)->{
            service.submit(() ->{
                CallableImageLoader cil= new CallableImageLoader(1, a, log);
                try{
                    cil.call();
                }catch (IOException e){
                    System.out.println("Empty picture");
                }catch (EmptyURLException exception){
                    System.out.println("Empty picture");
                }catch (Exception exc){
                    System.out.println("Empty picture");
                }
                System.out.println(Thread.currentThread().getName());
            });
        });

    }
}