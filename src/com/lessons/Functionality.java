package com.lessons;

import java.util.*;

public class Functionality {
    private List <Player> players = new ArrayList<>();


    public void add_player(){
        Player player;
        String name;
        Integer age;
        Integer rating;
        String team;

        Scanner scan = new Scanner(System.in);
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

        players.add(player);
    }

    public void showUniquePlayers(){
        Set<Player> uniquePlayer = new HashSet<>(players);
        int i = 1;
        for(Player player: uniquePlayer){
            System.out.println("==========Player " + i + "=========");
            System.out.println("Name: " + player.getName());
            System.out.println("Age: " + player.getAge());
            System.out.println("Rating: " + player.getRating());
            System.out.println("Team: " + player.getTeam());
            System.out.println("===========================");
            i++;
        }
    }

    public void showPlayersByRating(){

    }

    public void deletePlayer(){
        Set<Player> uniquePlayer = new HashSet<>(players);
        TreeMap<Integer, Player> playersMap = new TreeMap<>();
        Scanner scan = new Scanner(System.in);
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


    public void showTeams(){
        Set<String> teamList = new HashSet<>();
        Set<Player> uniquePlayer = new HashSet<>(players);

        for(Player team: uniquePlayer){
            teamList.add(team.getTeam());
        }

        for(String team: teamList){
            System.out.println(team);
                for(Player player: uniquePlayer){
                    if(team.equals(player.getTeam())){
                        System.out.println("Name: " + player.getName() + "; Age: " + player.getAge() + "; Rating " + player.getRating());
                    }
                }
        }
    }
}
