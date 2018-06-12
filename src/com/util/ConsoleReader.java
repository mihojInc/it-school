package com.util;

import com.util.tttFiles.Func;

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

        Func func = new Func();
        func.getFieldDesk();

        int step = 1;
        do {
            if (step % 2 == 0)
                func.cpuStep();
            else
                func.playerStep(scanner);
            func.getFieldDesk();
            step++;
        } while (func.chekWin() & step < 11);
    }

}
