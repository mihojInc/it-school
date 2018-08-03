package com.lessons;

import java.io.IOException;
import java.util.Scanner;

public class ChooseConnection {
    BodyOfChat chatWork = new BodyOfChat();
    public void chooseConnection(Scanner scan) throws IOException {
        int choice=0;
        System.out.println("If you want to use program as a server - print 1\n" +
                "If you want to use program as a client - print 2");

        choice = scan.nextInt();
        switch (choice){
            case 1:
                chatWork.chatWork(chatWork.connectAsServer());
                break;
            case 2:
                chatWork.chatWork(chatWork.connectAsClient());
                break;
            default:
                System.out.println("Incorrect data");
        }
    }
}
