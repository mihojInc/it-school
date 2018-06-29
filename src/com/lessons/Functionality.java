package com.lessons;

import java.util.*;

/**
 * Class with methods for working with players
 */
public class Functionality {
    private List <Player> players = new ArrayList<>();
    private HashMap<String, HashSet<Player>> teamList = new HashMap<>();
    private PlayerService service = new PlayerService();

    /**
     * method for adding new player to list
     */
    public void add_player(Scanner scan){
        Player player;
        String name;
        Integer age;
        Integer rating;
        String team;

        System.out.println("Enter player's name ");
        name = scan.nextLine();

        System.out.println("Enter player's team ");
        team = scan.nextLine();

        System.out.println("Enter player's age ");
        while (!scan.hasNextInt()) {
            System.out.println("It's not a number" + "Please enter number");
            scan.next();
        }
        age = scan.nextInt();

        System.out.println("Enter player's rating ");
        while (!scan.hasNextInt()) {
            System.out.println("It's not a number" + "Please enter number");
            scan.next();
        }
        rating = scan.nextInt();

        if(!teamList.containsKey(team)){
            teamList.put(team, new HashSet<>());
            teamList.get(team).add(new Player(name, age, rating, team, PlayerSequence.getNext()));
        }else{
            teamList.get(team).add(new Player(name, age, rating, team, PlayerSequence.getNext()));
        }

    }

    /**
     * Method for showing list of unique players
     */
    public void showUniquePlayers(){
        int i = 1;
        for(Map.Entry<String, HashSet<Player>> entry : teamList.entrySet()){
            service.printPlayerListStartId(entry.getValue());
        }
    }

    /**
     * methods shows players by their rating from the lowest to the highest
     */
    public void showPlayersByRating(){
        service.printPlayerListStartRating(service.sortPlayersByRating(teamList));
    }

    /**
     * method deletes player from the list
     */
    public void deletePlayer(Scanner scan){
        long id;
        long deletePlayer = 0;

        for(HashSet<Player> playerList: teamList.values()){
            service.printPlayerListStartId(playerList);
        }
        System.out.println("Enter id of player, you want to delete");

        while (!scan.hasNextInt()) {
            System.out.println("It's not a number" + "Please enter number");
            scan.next();
        }
        id = scan.nextInt();
        if(id > (PlayerSequence.getNext() - 1)){
            System.out.println("There is no player with this number");
            return;
        }

        for(HashSet<Player> playerList: teamList.values()){
            for(Player player: playerList){
                if(id == player.getId()){
                    playerList.remove(player);
                    deletePlayer = id;
                    break;
                }
            }

        }
        if(deletePlayer == 0){
            System.out.println("There is no player with this number");
            return;
        }
    }


    /**
     * Method shows existing teams and players for every team
     */
    public void showTeams(){
        for(Map.Entry<String, HashSet<Player>> entry : teamList.entrySet()){
            System.out.println("==========Team: " + entry.getKey() + "=========");
            service.printPlayerListStartId(entry.getValue());
            System.out.println("===========================");
        }
    }

    /**
     * method compares sum of player's rating of 2 teams
     */
    public void play(Scanner scan){
        String team1;
        String team2;
        Integer rating1 = 0;
        Integer rating2 = 0;

        System.out.println("Enter name of first team");
        team1 = scan.nextLine();
        System.out.println("Enter name of second team");
        team2 = scan.nextLine();

        for(Map.Entry<String, HashSet<Player>> entry : teamList.entrySet()){
            if(team1.equals(entry.getKey())){
                for(Player player:entry.getValue()){
                    rating1+=player.getRating();
                }
            }
            if(team2.equals(entry.getKey())){
                for(Player player:entry.getValue()){
                    rating2+=player.getRating();
                }
            }
        }

        if(rating1 == 0 || rating2 == 0){
            System.out.println("You print incorrect name of team or one of the teams has no players");
        }else if(rating1>rating2){
            System.out.println(team1 + " win with score: " + rating1 + ":" + rating2);
        }else if(rating1<rating2){
            System.out.println(team2 + " win with score: " + rating2 + ":" + rating1);
        }else{
            System.out.println("Both teams have the same rating");
        }
    }
}
