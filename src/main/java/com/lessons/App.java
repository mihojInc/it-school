package com.lessons;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        File fileWithLinks = new File("./src/main/java/com/lessons/links");
        Scanner scan = new Scanner(System.in);
        Interaction interaction = new Interaction();

        interaction.printImagesQuantity(scan);
        interaction.chooseWayOfDownload(scan);

    }
}
