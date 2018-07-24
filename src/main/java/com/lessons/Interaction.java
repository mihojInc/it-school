package com.lessons;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Interaction {
    private File fileWithLinks = new File("./src/main/java/com/lessons/links");
    private Integer imagesCounter = 0;


    public Integer printImagesQuantity(Scanner scan){
        System.out.println("Print quantity of images, you want to download");
        while(!scan.hasNextInt()){
            System.out.println("You enter wrong data, please print number");
            scan.next();
        }
        Integer quantity = scan.nextInt();
        this.imagesCounter = quantity;
        return quantity;
    }

    public void chooseWayOfDownload(Scanner scan){
        Integer LinksCounter = 0;
        String link = "";
        Loader download = new Loader();
        System.out.println("Choose the way of download:\n" +
                "print 1, if you want to download images from file\n" +
                "print 2, if you want to enter links from console");

        while(!scan.hasNextInt()){
            System.out.println("You enter wrong data, please print number");
            scan.next();
        }
        Integer choice = scan.nextInt();
        switch (choice){
            case 1:
                DownloadService downloadService = new DownloadService();
                downloadService.downloadFromFile(imagesCounter);
                break;
            case 2:
                DownloadService downloadServiceConsole = new DownloadService();
                downloadServiceConsole.downloadFromConsole(imagesCounter);
                break;
            default:
                System.out.println("You enter wrong number, please print 1 or 2");
        }
    }

    public String printLink(Scanner scan){
        System.out.println("Enter image's link for download");
        String link = scan.next();
        return link;
    }
}
