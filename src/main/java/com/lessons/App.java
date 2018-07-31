package com.lessons;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File fileWithLinks = new File("./src/main/java/com/lessons/links");
        File logFile = new File("./src/main/java/com/lessons/log");
        Scanner scan = new Scanner(System.in);
        Interaction interaction = new Interaction();

        interaction.printImagesQuantity(scan);
        interaction.chooseWayOfDownload(scan);

        LogService logService = new LogService();
        logService.run(new DownloadService(), logFile);
    }
}
