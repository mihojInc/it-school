package com.lessons.console;

import com.lessons.Downloader;

import java.util.Scanner;

/**
 * Created by Mihail Kolomiets on 25.07.18.
 */
public class ConcoleHelper {

    Scanner scanner = new Scanner(System.in);
    ConsoleCommand consoleCommand = ConsoleCommand.H;
    Downloader downloader = new Downloader();

    public void start() {
        while (consoleCommand != ConsoleCommand.Q) {

            switch (consoleCommand) {

                //load by file address
                case DFF:
                    downloader.loadAllFiles();
                    break;

                case DFC:
                    downloader.downloadFromConsole(scanner.nextLine());
                    break;

                case H:
                default:
                    System.out.println(consoleCommand.getStringAbout());
                    break;
            }


            consoleCommand = consoleCommand.getByInterpritate(scanner.nextLine());

        }
    }

}
