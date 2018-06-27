package com.lessons;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        /*FootballManager fm = new FootballManager();
        fm.addNewTeam(input);
        fm.addNewPlayer(input);
        System.out.println("next");
        fm.addNewPlayer(input);
        System.out.println("next");
        fm.addNewPlayer(input);
        System.out.println("next");
        fm.uniquePlayes();
        fm.sortedByRating();
        fm.playersByTeam();*/
        Interaction inter = new Interaction();
        inter.interactionWithUser(input);


    }
}
