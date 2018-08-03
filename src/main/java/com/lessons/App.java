package com.lessons;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ChooseConnection connection = new ChooseConnection();
        connection.chooseConnection(scan);
    }
}
