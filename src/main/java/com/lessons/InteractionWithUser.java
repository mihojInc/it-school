package com.lessons;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class InteractionWithUser {

    public static void interact(Scanner scanner){
        boolean isOn = true;
        while (isOn){
            System.out.println("If you want to type links enter C");
            System.out.println("If you want to use file enter F ");
            if(scanner.hasNextLine()){
                String choose = scanner.nextLine();
                if(choose.equals("C")){
                    List<String> links = consoleDownload(scanner);
                    DownloadService.download(links);
                    isOn = false;}
                else if(choose.equals("F")){
                    List<String> links = FileUtil.readMyFile();
                    DownloadService.download(links);
                    isOn = false;}
                else{System.out.println("Incorrect input.Try again");}
            } else{
                System.out.println("Error.Try again");
            }
        }
    }

    public static List<String> consoleDownload(Scanner scanner){
        int numberOfDownloads = 0;
        String tempLink = "";


        System.out.println("Enter the number of downloads");

        if(scanner.hasNextInt())
        {numberOfDownloads = scanner.nextInt();
            scanner.nextLine();
        }else {
            System.out.println("Incorrect number of downloads");}

        List<String> links = new LinkedList<>();

        while (links.size() < numberOfDownloads){
            if(scanner.hasNextLine())
            {tempLink = scanner.nextLine();
                links.add(tempLink);
            }else {
                System.out.println("Incorrect input");}
        }
        return links;
    }

}
