package com.lessons;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Field field = new Field();
        Scanner scanner = new Scanner(System.in);
        System.out.println("СТАРТ ИГРЫ!");
        field.displayField();
        while (field.checkWinner() == ' ' && field.freeFields()) {
            field.playerMove(scanner);
            field.computerMove();
            field.displayField();
        }
        if (field.checkWinner() == 'X') {
            System.out.println("ВЫ ПОБЕДИЛИ!");
        }
        if (field.checkWinner() == 'O') {
            System.out.println("ВЫ ПРОИГРАЛИ!");
        }
        if (field.checkWinner() == ' ' && !field.freeFields()) {
            System.out.println("КОНЕЦ!");
        }
    }
}
