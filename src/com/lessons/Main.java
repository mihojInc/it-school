package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        FootballManager footballManager = new FootballManager();
        Scanner scanner = new Scanner(System.in);
        footballManager.startGame(scanner);
        footballManager.showFootballManager();


    }
}
