package com.lessons;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        FileUtil.clear();
        Scanner input = new Scanner(System.in);
        InteractionWithUser.interact(input);
    }
}
