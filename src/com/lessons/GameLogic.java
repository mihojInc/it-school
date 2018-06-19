package com.lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan
 * class for game logic
 *
 */
public class GameLogic {
    /**
     *  "X"
     */
    private static final String X = "X";
    /**
     * zero
     */
    private static final String ZERO = "0";
    /**
     * column game'field
     */
    private static final int COLUMN = 3;
    /**
     * line game'field
     */
    private static final int LINE = 3;
    /**
     * list for game's field
     */
    private String[][] field = new String[COLUMN][LINE];
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    /**
     * list for choosing number
     */
    private List<Integer> listNumbers = new ArrayList<>();

    /**
     * start for aplication
     * @throws IOException
     */
    public void beginOrNoGame()  {
        drawsField();
        System.out.println("If you want play type 'y' or 'q' if you don't want play ");
        String firstCommand = null;
        try {
            firstCommand = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (firstCommand.equals(Commands.YES.getCommandName())) {
            startPlay();
        } else {
            if (firstCommand.equals(Commands.QUIT.getCommandName())) {
                return;
            } else {
                System.out.println("enter only 'y' or 'q'");
            }
        }
    }

    /**
     * draw field to console
     */
    private void drawsField() {
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < LINE; j++) {
                if (i < COLUMN - 1) {
                    if (field[i][j] == null) {
                        System.out.print("__");
                    } else {
                        System.out.print(field[i][j] + "_");
                    }
                } else {
                    if (field[i][j] == null) {
                        System.out.print("  ");
                    } else {
                        System.out.print(field[i][j] + " ");
                    }
                }
                if (j < LINE - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    /**
     * method for start game if some players want play
     */
    private void startPlay() {
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println("player1 go");
                choosePlace();
                putXorO(X);
                drawsField();
            } else {
                System.out.println("player2 go");
                choosePlace();
                putXorO(ZERO);
                drawsField();
            }
            if (i > 3) {
                if (searchWinner().equals(X)) {
                    System.out.println("winner player1");
                } else {
                    if (searchWinner().equals(ZERO)) {
                        System.out.println("winner player2");
                    } else {
                        System.out.println("draw");
                    }
                }
                return;
            }
        }
    }

    /**
     * print option for choose
     */
    private void choosePlace() {
        int number = 0;
        System.out.println("choose ");
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < LINE; j++) {
                if (field[i][j] == null) {
                    System.out.print(i * 3 + j + ",");
                    listNumbers.add(i * 3 + j);
                }
                number++;
            }
        }
        System.out.println();
    }

    /**
     * put on field "X" or "O"
     *
     * @param sign "X" or "O"
     */
    private void putXorO(String sign) {
        int pointer = 0;
        int number = 0;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("enter only number");
        }
        if (listNumbers.contains(number)) {
            for (int i = 0; i < COLUMN; i++) {
                for (int j = 0; j < LINE; j++) {
                    if (pointer == number) {
                        field[i][j] = sign;
                    }
                    pointer++;
                }
            }
        } else {
            System.out.println("enter only");
            choosePlace();
            putXorO(sign);
        }
    }

    /**
     * search winner  "X" or "O"
     *
     * @return "X" or "O"
     */
    public String searchWinner() {
        int matches;
        for (int i = 0; i < COLUMN; i++) {
            matches = 0;
            for (int j = 0; j < LINE; j++) {
                if (field[i][0] != null && field[i][0].equals(field[i][j])) {
                    matches++;
                }
            }
            if (matches == 3) {
                return field[i][0];
            }
        }
        for (int j = 0; j < LINE; j++) {
            matches = 0;
            for (int i = 0; i < COLUMN; i++) {
                if (field[0][j] != null && field[0][j].equals(field[i][j])) {
                    matches++;
                }
            }
            if (matches == 3) {
                return field[0][j];
            }
        }
        if (field[0][0] != null && field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2])) {
            return field[0][0];
        }
        if (field[0][2] != null && field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0])) {
            return field[0][2];
        }
        return "draw";
    }
}
