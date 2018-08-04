package com.lessons.Client;

public class Client {
    static String HOST = "localhost";
    static int PORT = 3434;

    public static void main(String[] args) {
        new ClientHelper(HOST, PORT);
    }
}

