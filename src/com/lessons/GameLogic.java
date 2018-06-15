package com.lessons;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    /**
     * it is constants that defines available states of cell
     */
    private static final String CROSS = " X ";
    private static final String ZERO = " O ";
    private static final String EMPTYCELL = " _ ";
    private static String currentGamer;

    /**
     * sizes of game field
     */
    private static final int COL = 3, STR = 3;
    /**
     * game field 3x3
     */
    private static String[][] gameField = new String[STR][COL];
    private static int gameStat;
    private static final int GAMEISON = 0, ITISDRAW = 1, WINNERISX = 2, WINNERISO = 3;
    private static Scanner input;

    public static void game(Scanner inputNew){
        input = inputNew;
        startGame();
        do {
            getPlayerMove();
            analyzeGame();
            displayField();
            if(gameStat == WINNERISX){
                System.out.println("'X' is a winner!");
            } else if(gameStat == WINNERISO){
                System.out.println("'O' is a winner!");
            } else if(gameStat == ITISDRAW){
                System.out.println("It is draw!");
            }
            currentGamer = (currentGamer == CROSS?ZERO:CROSS);
        }
        while(gameStat==GAMEISON);
    }

    /**
     * it is the method to start game. This method creates empty game field
     */
    public static void startGame(){
        for(int i = 0; i < STR; i++){
            for(int j = 0; j < COL; j++){
                gameField[i][j] = EMPTYCELL;
            }
        }
        currentGamer = CROSS;
        displayField();
    }

    /**
     * this method asks current gamer in which position he want to move
     */
    public static void getPlayerMove(){
        boolean correctInput = false;
        int k = 0;
        do {
            if (currentGamer.equals(CROSS)) {
                System.out.println("Gamer" + currentGamer + ", enter number of string (1-3) and number of column through space!");
                int i = input.nextInt() - 1;
                int j = input.nextInt() - 1;
                if (i >= 0 && i < STR && j >= 0 && j < COL && gameField[i][j].equals(EMPTYCELL)) {
                    gameField[i][j] = currentGamer;
                    correctInput = true;
                } else {
                    System.out.println("Position [" + (i + 1) + "][" + (j + 1) + "] is incorrect. Try again!");
                }
            } else if (currentGamer.equals(ZERO)) {
                System.out.println("Computer made its choice");
                final Random compChoose = new Random();
                int i = compChoose.nextInt(2);
                int j = compChoose.nextInt(2);
                if (i >= 0 && i < STR && j >= 0 && j < COL && gameField[i][j].equals(EMPTYCELL)) {
                    gameField[i][j] = currentGamer;
                    correctInput = true;
                } else {
                    System.out.println("Computer's step is wrong so it is trying again");
                    k++;
                    if (k > 10) {
                        System.out.println("Computer can't continue, so the game is over. Try it later! Sorry!");
                        System.exit(0);}

                }

            }
        }
        while (!correctInput);
    }

    /**
     * this method analyzes game status (who is win or it is draw)
     */
    public static void analyzeGame(){
        String winner  = getWinner();
        if(winner.equals(CROSS)){
            gameStat = WINNERISX;
        } else if (winner.equals(ZERO)){
            gameStat = WINNERISO;
        } else if(isFull()){
            gameStat = ITISDRAW;
        } else {
            gameStat = GAMEISON;
        }

    }

    /**
     * it will return true if game field is full
     */

    public static boolean isFull(){
        for(int i = 0; i < STR; i++){
            for(int j = 0; j < COL; j++) {
                if(gameField[i][j].equals(EMPTYCELL)){
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * This method checks if it is a winner exists for each step, and if it exists, it returns its name
     * @return name of winner
     */
    public static String getWinner(){
        int numberOfMatches;
        /**
         * check if there are three similar elements in string and return name of winner if he exists
         */
        for(int i = 0; i < STR; i++){
            numberOfMatches = 0;
            for(int j = 0; j < COL; j++){
                if(gameField[0][j]!=EMPTYCELL && gameField[i][0]==gameField[i][j]){
                    numberOfMatches++;
                }
            }
            if (numberOfMatches == 3){
                return gameField[i][0];
            }
        }
        /**
         * check if there are three similar elements in column and return name of winner if he exists
         */
        for(int j = 0; j < COL; j++){
            numberOfMatches = 0;
            for(int i = 0; i < STR; i++){
                if(gameField[0][j]!=EMPTYCELL && gameField[0][j]==gameField[i][j]){
                    numberOfMatches++;
                }
            }
            if (numberOfMatches == 3){
                return  gameField[0][j];
            }
        }
        /**
         * check if there are three similar elements in diagonals and return name of winner if he exists
         */
        if(gameField[0][0]!=EMPTYCELL && gameField[0][0]==gameField[1][1] && gameField[0][0]==gameField[2][2] ){
            return gameField[0][0];
        }
        if(gameField[0][2]!=EMPTYCELL && gameField[0][2]==gameField[1][1] && gameField[0][2]==gameField[2][0] ){
            return gameField[0][2];
        }

        return EMPTYCELL;
    }

    /**
     * method that displays game field on the console
     */
    public static void displayField(){
        for(int i = 0; i < STR; i++){
            for(int j = 0; j < COL; j++){
                System.out.print(gameField[i][j]);
                if(j != COL-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i != STR-1){
                System.out.println("------------");
            }
        }
        System.out.println();

    }
}
