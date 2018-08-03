package src.main.java.com.lessons;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Please choose type of work:");
        System.out.println("1.Client");
        System.out.println("2.Server");
        Scanner scanner = new Scanner(System.in);
        int oper = scanner.nextInt();

        switch (oper){
            case 1:
                System.out.println("You will be client");
                ServiceClient.startClient();
            case 2:
                System.out.println("You will be server");
                ServiceServer.startServer();
        }

    }
}
