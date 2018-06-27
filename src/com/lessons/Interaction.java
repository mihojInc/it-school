package com.lessons;

import java.util.Scanner;

public class Interaction {

    FootballManager newFootballManager;

    Interaction() {
        newFootballManager = new FootballManager();
    }

    public void interactionWithUser(Scanner inp) {
        String result = "";


        while (true) {
            for (ListOfCommands com : ListOfCommands.values()) {
                System.out.println(com.getInstruction());
            }
            if (inp.hasNext()) {
                result = fromCode(inp);
            }else{
                System.out.println("Noooooothinggggg");
            }
            if (result.equals("addTeam")) {
                System.out.println("Add information about team in such form:");
                System.out.println("[nameOfTeam] [instructor] [country]");
                if (inp.hasNext()) {
                    System.out.println("Inp has next"+inp.nextLine());
                    newFootballManager.addNewTeam(inp);
                }
            } else if (result.equals("addPlayer")) {
                System.out.println("Add information about player in such form:");
                System.out.println("[nameOfPlayer] [age] [rating] [team]");
                if (inp.hasNext()) {
                    inp.nextLine();
                    String userInput = inp.nextLine();
                    newFootballManager.addNewPlayer(userInput );
                }

            } else if (result.equals("unique")) {
                newFootballManager.uniquePlayes();


            } else if (result.equals("byRating")) {
                newFootballManager.sortedByRating();


            } else if (result.equals("deletePlayer")) {


            } else if (result.equals("byTeams")) {
                newFootballManager.playersByTeam();


            } else if (result.equals("play")) {


            } else if (result.equals("exit")) {
                System.out.println("Good Bye");
                break;
            } else {
                System.out.println("Try again!");

            }
        }
    }


    public String fromCode(Scanner inp) {
        String choose = inp.next();
        for (ListOfCommands com : ListOfCommands.values()) {
            if (choose.equals(com.getCode().toString())) {
                return com.toString();
            }
        }
        return null;
    }
}
