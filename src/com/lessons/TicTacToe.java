package com.lessons;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /**
     * it is constants that defines available states of cell
     */
    private static final String cross = " X ";
    private static final String zero = " O ";
    private static final String emptyCell = " _ ";
    private static String currentGamer;

    /**
     * sizes of game field
     */
    private static final int col = 3, str = 3;
    /**
     * game field 3x3
     */
    private static String[][] gameField = new String[str][col];
    private static int gameStat;
    private static final int gameIsOn = 0, itIsDraw = 1, winnerIsX = 2, winnerIsO = 3;
    private static Scanner input = new Scanner(System.in);

    public static void game(){
        startGame();
        do {
            getPlayerMove();
            analyzeGame();
            displayField();
            if(gameStat == winnerIsX){
                System.out.println("'X' is a winner!");
            } else if(gameStat == winnerIsO){
                System.out.println("'X' is a winner!");
            } else if(gameStat == itIsDraw){
                System.out.println("It is draw!");
            }
            currentGamer = (currentGamer == cross?zero:cross);
        }
        while(gameStat==gameIsOn);
    }

    /**
     * it is the method to start game. This method creates empty game field
     */
    public static void startGame(){
        for(int i = 0; i < str; i++){
            for(int j = 0; j < col; j++){
                gameField[i][j] = emptyCell;
            }
        }
        currentGamer = cross;
        displayField();
    }

    /**
     * this method asks current gamer in which position he want to move
     */
    public static void getPlayerMove(){
        boolean correctInput = false;
        int k = 0;
        do {
            if (currentGamer.equals(cross)) {
                System.out.println("Gamer" + currentGamer + ", enter number of string (1-3) and number of column through space!");
                int i = input.nextInt() - 1;
                int j = input.nextInt() - 1;
                if (i >= 0 && i < str && j >= 0 && j < col && gameField[i][j].equals(emptyCell)) {
                    gameField[i][j] = currentGamer;
                    correctInput = true;
                } else {
                    System.out.println("Position [" + (i + 1) + "][" + (j + 1) + "] is incorrect. Try again!");
                }
            } else if (currentGamer.equals(zero)) {
                System.out.println("Computer made its choice");
                final Random compChoose = new Random();
                int i = compChoose.nextInt(2);
                int j = compChoose.nextInt(2);
                if (i >= 0 && i < str && j >= 0 && j < col && gameField[i][j].equals(emptyCell)) {
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
        if(winner.equals(cross)){
            gameStat = winnerIsX;
        } else if (winner.equals(zero)){
            gameStat = winnerIsO;
        } else if(isFull()){
            gameStat = itIsDraw;
        } else {
            gameStat = gameIsOn;
        }

    }

    /**
     * it will return true if game field is full
     */

    public static boolean isFull(){
        for(int i = 0; i < str; i++){
            for(int j = 0; j < col; j++) {
                if(gameField[i][j].equals(emptyCell)){
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
        for(int i = 0; i < str; i++){
            numberOfMatches = 0;
            for(int j = 0; j < col; j++){
                if(gameField[0][j]!=emptyCell && gameField[i][0]==gameField[i][j]){
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
        for(int j = 0; j < col; j++){
            numberOfMatches = 0;
            for(int i = 0; i < str; i++){
                if(gameField[0][j]!=emptyCell && gameField[0][j]==gameField[i][j]){
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
        if(gameField[0][0]!=emptyCell && gameField[0][0]==gameField[1][1] && gameField[0][0]==gameField[2][2] ){
            return gameField[0][0];
        }
        if(gameField[0][2]!=emptyCell && gameField[0][2]==gameField[1][1] && gameField[0][2]==gameField[2][0] ){
            return gameField[0][2];
        }

        return emptyCell;
    }

    /**
     * method that displays game field on the console
     */
    public static void displayField(){
        for(int i = 0; i < str; i++){
            for(int j = 0; j < col; j++){
                System.out.print(gameField[i][j]);
                if(j != col-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i != str-1){
                System.out.println("------------");
            }
        }
        System.out.println();

    }
}
