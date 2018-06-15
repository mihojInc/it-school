package com.lessons;

import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //initial scanner for read answer
        Scanner sc = new Scanner(System.in);
        //Create new class game
        Game game = new Game(sc);
        game.playGame();
    }
}
