package com.lessons;

import java.util.Random;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Scanner ansExit = new Scanner(System.in);
        Game game = new Game();
        game.draw();

        Random rnd = new Random(System.currentTimeMillis());
        int step = 0;


        boolean rez = false;
        do {
            game.initial();
            do {

                do {
                    System.out.println("Make a step");

                    step = sc.nextInt();
                    rez = game.step(step, false);

                } while (!rez);

                if (game.analizeWin()) break;

                game.draw();
                System.out.println("Computer step");

                do {

                    rez = game.step(Math.abs(rnd.nextInt(9)), true);
                } while (!rez);


                game.draw();
            } while (!game.analizeWin());


            game.draw();

            System.out.println("\n" + game.getWinner());

            System.out.println("Continue game? y/n");
        }while (ansExit.nextLine().equals("y"));


    }

}
