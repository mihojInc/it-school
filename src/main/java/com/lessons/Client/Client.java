package com.lessons.Client;

import java.util.Scanner;

public class Client {
    //IP и PORT сервера
    static String IP_ADDRESS = null;
    static Integer PORT = null;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("To connect to the server, enter its port: ");
        Integer connect = scanner.nextInt();
        System.out.print("And now enter the hosting address of the server: ");
        String hostAddress = scanner.next();
        if ((connect != null) && (hostAddress != null)) {
            PORT = connect;
            IP_ADDRESS = hostAddress;
            new ClientHelper(IP_ADDRESS, PORT);
        } else {
            System.out.println("Wrong connection!");
        }
    }
}

