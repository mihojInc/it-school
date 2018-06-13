package com.lessons;

import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //initial scanner for read answer
        Scanner sc = new Scanner(System.in);
        Scanner ansExit = new Scanner(System.in);
        //Create new class game
        Game game = new Game();


        boolean rez = false;
        do {
            //clear dashboard for game
            game.initial();
            //draw dashboard in current statment
            game.draw();
            //main loob of game. Loop is brake when user answer is exit
            do {
                //player step
                game.step(true);
                if (game.analizeWin()) break;
                game.draw();
                System.out.println("Computer step");
                game.step(false);
                game.draw();
            } while (!game.analizeWin());


            game.draw();

            System.out.println("\n" + game.getWinner());

            System.out.println("Continue game? y/n");
        } while (ansExit.nextLine().equals("y"));
    }
}
