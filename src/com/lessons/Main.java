package com.lessons;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        GamePlay gamePlay = new GamePlay(sc);
        gamePlay.playGame();
    }
}
