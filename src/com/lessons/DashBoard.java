package com.lessons;

public class DashBoard {


    /**
     * This procedure draw dashboard
     * Parametrs is a current position on game
     */
    public static void draw(String[][] dash) {

        int i = 0;
        int k = 0;
        for (i = 0; i < 3; i++) {
            for (k = 0; k < 3; k++) {

                if (k == 2) {

                    if (!dash[i][k].equals("")) {//check if this spot is free

                        if (i != 2) // check if its spot is last. We have to drow another line in last spots
                            System.out.print(dash[i][k] + "_");
                        else
                            System.out.print(dash[i][k] + "  ");
                    } else {
                        if (i != 2)
                            System.out.print("__");


                    }
                    continue;
                }


                if (!dash[i][k].equals("")) {

                    if (i != 2)
                        System.out.print(dash[i][k] + "_|");
                    else System.out.print(dash[i][k] + " |");


                } else {
                    if (i != 2)
                        System.out.print("__|");
                    else {
                        System.out.print("  |");
                    }

                }


            }

            System.out.println();


            k = 0;
        }

    }
}
