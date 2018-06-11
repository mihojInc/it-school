package com.lessons;
import java.util.Random;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        game.draw();

        Random rnd = new Random(System.currentTimeMillis());
        int step  = 0;


        boolean rez = false;

        do{
            System.out.println("Make a step");

            step = sc.nextInt();

            do {
                rez = game.step(step, false);

            }while (!rez);

            do {

                rez = game.step(Math.abs(rnd.nextInt(9)), true);
            }while (!rez);

            game.draw();
        }while (!game.analizeWin());



    }
}
