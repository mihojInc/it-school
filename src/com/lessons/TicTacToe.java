package com.lessons;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static GameLogic  newGame;

    public static void startGame(Scanner in){
        //newGame = new GameLogic();
        newGame.game(in);
    }
}
