package com.lessons;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Operation {
    /**
     * Main action in program. Here you have to chose type of downloading images
     * @param sc
     */
    public void mainOperation(Scanner sc) throws Exception {


        LogService log = new LogService(new File("Log.txt"));
        DownloadService ds = new DownloadService(sc, log);
        System.out.println("How do you want to load images: from file (1), one by one (2)");
        switch (sc.nextInt()) {
            case 1:
                ds.downloadFromFile();
                break;
            case 2:
                ds.downloadOneByOne();
                break;
                default:
                    break;
        }
    }
}
