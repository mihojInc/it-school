package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        int curPos = 0;
        int ans = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Define size of array");

        ArrayMy arr = new ArrayMy(sc.nextInt());

        do {
            for (Commands c : Commands.values()) {
                System.out.println((c.getPos()) + " " + c.getDescribeComman());
            }

            ans = sc.nextInt();
        switch (ans){
            case 0:
                System.out.println("Write number");
                arr.add(sc.nextInt());
                arr.list();
                break;
            case 1:
                arr.sortBubl(true);
                arr.list();
                break;
            case 2:
                arr.sortBubl(false);
                arr.list();
                break;
            case 3:
                arr.sortIncert(true);
                arr.list();
                break;
            case 4:
                arr.sortIncert(false);
                arr.list();
                break;
            case 5:
                arr.clear();
                break;

        }
        }while(ans!= com.lessons.Commands.QUIT.getPos());
    }
}
