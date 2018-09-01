package com.lessons.Common;

import java.util.Scanner;

/**
 * This class paint current figure position on the board
 */
public class DashBoard {
    public static void draw(Statment statment)    {
        System.out.println("_____________________________________________________");
        System.out.println(" |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < 8; i++){
            System.out.print(i + "|");
            for (int k = 0; k < 8; k++) {
                if(statment.getFig(i, k).getColor()==Colors.EMPTY){
                    System.out.print("     |");
                    continue;
                }
                if (statment.getFig(i, k).getColor() == Colors.WHITE) {
                    System.out.print("  W  |");
                }
                if (statment.getFig(i, k).getColor() == Colors.BLACK) {
                    System.out.print("  B  |");
                }
            }
            System.out.println("\n-----------------------------------------------------");
        }
    }
}