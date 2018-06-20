package com.lessons;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //new scanner for enter users answer
        Scanner sc = new Scanner(System.in);
        //create new game
        GamePlay gamePlay = new GamePlay(sc);
        gamePlay.playGame();
    }
}
