package com.lessons.Helper;

import com.lessons.Client.Client;
import com.lessons.Server.Server;

import java.io.IOException;
import java.util.Scanner;

public class Helper {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        Client client = new Client();

        System.out.println("To start the server press -1-, to start the client press -2-");
        Scanner scanner = new Scanner(System.in);

        int value = scanner.nextInt();

        if(value == 1) {
            server.start();
        } else if(value == 2) {
            client.start();
        } else {
            System.out.println("You entered an incorrect number, try again!");
        }
    }
}
