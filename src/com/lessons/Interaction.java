package com.lessons;

import java.util.Scanner;

public class Interaction {

    Functionality functions;

    public Interaction(Functionality functions){
        this.functions = functions;
    }

    public void mainChoice(Scanner scan){

        while(true){
            for(Commands command: Commands.values()){
                System.out.println(command.getMessage());
            }
            String checkString = scan.nextLine();

            if (checkString.equals(Commands.ADD_PLAYER.getCommand())){
                functions.add_player();
            }else if (checkString.equals(Commands.UNIQUE_PLAYERS.getCommand())){
                functions.showUniquePlayers();
            }else if (checkString.equals(Commands.RATING_PLAYERS.getCommand())){

            }else if (checkString.equals(Commands.DELETE_PLAYER.getCommand())){

            }else if (checkString.equals(Commands.SHOW_TEAM_AND_PLAYERS.getCommand())){

            }else if (checkString.equals(Commands.PLAY_MATCH.getCommand())){

            }else if (checkString.equals(Commands.EXIT.getCommand())){
                System.out.println("Program is finished");
                return;
            }else{
                System.out.println("Incorrect data");
            }
        }

    }

}
