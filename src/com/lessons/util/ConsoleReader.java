package com.lessons.util;

import com.lessons.util.gameFiles.GameProcess;

import java.util.Scanner;

/**
 * Include method for show in console
 */
public class ConsoleReader {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Simple game in console
     */
    public static void ticTacToe() {
        System.out.println("Welcome to game");

        GameProcess gameProcess = new GameProcess();
        gameProcess.getFieldDesk();

        int step = 1;
        while (gameProcess.checkWin() & step < 11) {
            if (step % 2 == 0)
                gameProcess.cpuStep();
            else
                gameProcess.playerStep(scanner);

            if (step != 10)
                gameProcess.getFieldDesk();
            step++;
        }
    }

}
