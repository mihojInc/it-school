package com.lessons.Client;

public class Client {
    private static final int PORT = 3443;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        new ClientSomething(PORT, HOST);
    }
}
