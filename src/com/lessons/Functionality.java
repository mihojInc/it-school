package com.lessons;

import java.util.*;

/**
 * Class with methods for working with players
 */
public class Functionality {
    private List <Player> players = new ArrayList<>();
    private HashMap<String, List<Player>> teamList = new HashMap<>();

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

        player = new Player(name, age, rating, team);

        //players.add(player);
        if(!teamList.containsKey(player.getTeam())){
            teamList.put(player.getTeam(), new ArrayList<>());
            teamList.get(player.getTeam()).add(player);
        }else{
            teamList.get(player.getTeam()).add(player);
        }

    }

    /**
     * Method for showing list of unique players
     */
    public void showUniquePlayers(){
        int i = 1;
        HashMap<String, HashSet<Player>> uniqueList = new HashMap(teamList);
        for(Map.Entry<String, HashSet<Player>> entry : uniqueList.entrySet()){
            for(Player player:  entry.getValue()){
                System.out.println("==========Player " + i + "=========");
                System.out.println("Name: " + player.getName());
                System.out.println("Age: " + player.getAge());
                System.out.println("Rating: " + player.getRating());
                System.out.println("Team: " + entry.getKey());
                System.out.println("===========================");
                i++;
            }


        }
    }

    /**
     * methods shows players by their rating from the lowest to the highest
     */
    public void showPlayersByRating(){
        Set<Player> uniquePlayer = new HashSet<>(players);
        SortByRating ratingSort = new SortByRating();
        TreeSet<Player> playerTree = new TreeSet<>(ratingSort);
        playerTree.addAll(uniquePlayer);

        for(Player  player : playerTree){
            System.out.println(player.getRating() + "; Name: " + player.getName() + "; Team: " + player.getTeam() + "; Age " + player.getAge());
        }

    }

    /**
     * method deletes player from the list
     */
    public void deletePlayer(Scanner scan){
        Set<Player> uniquePlayer = new HashSet<>(players);
        TreeMap<Integer, Player> playersMap = new TreeMap<>();
        Integer number;
        Player deletePlayer;

        int i = 1;
        for (Player player: uniquePlayer){
            playersMap.put(i,player);
            i++;
        }

        for(Map.Entry<Integer, Player> entry : playersMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getName());
            System.out.println("Team: " + entry.getValue().getTeam() + "; Age: " + entry.getValue().getAge() + "; Rating " + entry.getValue().getRating() + "\n");
        }

        System.out.println("Enter number of player, you want to delete");

        while (!scan.hasNextInt()) {
            System.out.println("It's not a number" + "Please enter number");
            scan.next();
        }
        number = scan.nextInt();
        if(number > playersMap.lastKey()){
            System.out.println("There is no player with this number");
        }else{
            deletePlayer = playersMap.get(number);
            players.remove(deletePlayer);
        }
    }

    /**
     * Method shows existing teams and players for every team
     */
    public void showTeams(){
        HashMap<String, HashSet<Player>> uniqueList = new HashMap(teamList);
        for(Map.Entry<String, HashSet<Player>> entry : uniqueList.entrySet()){
            System.out.println("==========Team: " + entry.getKey() + "=========");
            for(Player player:  entry.getValue()){
                System.out.println("Name: " + player.getName() + "; Age: " + player.getAge() + "; Rating " + player.getRating());
            }

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

        HashMap<String, HashSet<Player>> uniqueList = new HashMap(teamList);
        for(Map.Entry<String, HashSet<Player>> entry : uniqueList.entrySet()){
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

//        for(Player rating: players){
//            if(team1.equals(rating.getTeam())){
//                rating1+=rating.getRating();
//            }
//            if(team2.equals(rating.getTeam())){
//                rating2+=rating.getRating();
//            }
//        }

        if(rating1 == 0 || rating2 == 0){
            System.out.println("You print incorrect name of team");
        }else if(rating1>rating2){
            System.out.println(team1 + " win with score: " + rating1 + ":" + rating2);
        }else if(rating1<rating2){
            System.out.println(team2 + " win with score: " + rating2 + ":" + rating1);
        }else{
            System.out.println("Both teams have the same rating");
        }
    }
}
