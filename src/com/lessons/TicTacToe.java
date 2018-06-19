package com.lessons;

import java.util.Random;
import java.util.Scanner;

import static com.lessons.Field.COL;
import static com.lessons.Field.STR;

public class TicTacToe {

    private static Field newField;

    /**
     * it is constants that defines available states of cell
     */
    public static final String CROSS = " X ";
    public static final String ZERO = " O ";
    public static final String EMPTYCELL = " _ ";
    public static String currentGamer;


    private static int gameStat;
    private static final int GAMEISON = 0, ITISDRAW = 1, WINNERISX = 2, WINNERISO = 3;
    private static Scanner input;

    public static void game(Scanner inputNew){
        input = inputNew;
        newField = new Field();
        newField.startGame();
        currentGamer = CROSS;
        do {
            getPlayerMove();
            analyzeGame();
            newField.displayField();
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
                if (i >= 0 && i < STR && j >= 0 && j < COL && newField.getGameField(i,j).equals(EMPTYCELL)) {
                    newField.setGameField(i,j,currentGamer);
                    correctInput = true;
                } else {
                    System.out.println("Position [" + (i + 1) + "][" + (j + 1) + "] is incorrect. Try again!");
                }
            } else if (currentGamer.equals(ZERO)) {
                System.out.println("Computer made its choice");
                final Random compChoose = new Random();
                int i = compChoose.nextInt(2);
                int j = compChoose.nextInt(2);
                if (i >= 0 && i < STR && j >= 0 && j < COL && newField.getGameField(i,j).equals(EMPTYCELL)) {
                    newField.setGameField(i,j,currentGamer);
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
        } else if(newField.isFull()){
            gameStat = ITISDRAW;
        } else {
            gameStat = GAMEISON;
        }

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
                if(newField.getGameField(0,j)!=EMPTYCELL && newField.getGameField(i,0)==newField.getGameField(i,j)){
                    numberOfMatches++;
                }
            }
            if (numberOfMatches == 3){
                return newField.getGameField(i,0);
            }
        }
        /**
         * check if there are three similar elements in column and return name of winner if he exists
         */
        for(int j = 0; j < COL; j++){
            numberOfMatches = 0;
            for(int i = 0; i < STR; i++){
                if(newField.getGameField(0,j)!=EMPTYCELL && newField.getGameField(0,j)==newField.getGameField(i,j)){
                    numberOfMatches++;
                }
            }
            if (numberOfMatches == 3){
                return  newField.getGameField(0,j);
            }
        }
        /**
         * check if there are three similar elements in diagonals and return name of winner if he exists
         */
        if(newField.getGameField(0,0)!=EMPTYCELL && newField.getGameField(0,0)==newField.getGameField(1,1) && newField.getGameField(0,0)==newField.getGameField(2,2) ){
            return newField.getGameField(0,0);
        }
        if(newField.getGameField(0,2)!=EMPTYCELL && newField.getGameField(0,2)==newField.getGameField(1,1) && newField.getGameField(0,2)==newField.getGameField(2,0) ){
            return newField.getGameField(0,2);
        }

        return EMPTYCELL;
    }


}
