package com.lessons;

import java.util.Scanner;

/**
 * Class for interaction with user
 */
public class Interaction {

    Functionality functions;

    /**
     * constructor. Takes object of class with functions
     * @param functions
     */
    public Interaction(Functionality functions){
        this.functions = functions;
    }

    /**
     * Method allows user to choose command. And performs congruent function
     * @param scan
     */

    public void mainChoice(Scanner scan){

        while(true){
            for(Commands command: Commands.values()){
                System.out.println(command.getMessage());
            }

            Commands command = Commands.getCommandTitle(scan.nextLine());

            if(command != null){
                switch (command){
                    case ADD_PLAYER:
                        functions.add_player(scan);
                        scan.nextLine();
                        break;
                    case UNIQUE_PLAYERS:
                        functions.showUniquePlayers();
                        break;
                    case RATING_PLAYERS:
                        functions.showPlayersByRating();
                        break;
                    case DELETE_PLAYER:
                        functions.deletePlayer(scan);
                        scan.nextLine();
                        break;
                    case PLAY_MATCH:
                        functions.play(scan);
                        break;
                    case SHOW_TEAM_AND_PLAYERS:
                        functions.showTeams();
                        break;
                    case EXIT:
                        System.out.println("Program is finished");
                        return;
                }
            }else{
                System.out.println("Incorrect data");
            }

        }

    }

}
