package com.lessons;

import java.util.*;

public class PlayerService {


    public TreeSet<Player> sortPlayersByRating(Map<String, HashSet<Player>> playersMap){
        Comparator<Player> COMPORATOR = new Comparator<Player>() {
            public int compare(Player o1, Player o2) {
                if (o1.getRating() >= o2.getRating()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        TreeSet<Player> playerTree = new TreeSet<>(COMPORATOR);
        for(HashSet<Player> player: playersMap.values()){
            playerTree.addAll(player);
        }
        return playerTree;
    }

    public void printPlayerListStartId(Collection<Player> players){
        for(Player player: players){
            printPlayerStartId(player);
        }
    }

    public void printPlayerListStartRating(Collection<Player> players){
        for(Player player: players){
            printPlayerStartRating(player);
        }
    }

    public void printPlayerStartId(Player player){
        System.out.println("Id: " + player.getId() + ". Name: " + player.getName() + "; Team: " + player.getTeam() + "; Rating: " + player.getRating() + "; Age " + player.getAge() + ";");
    }

    public void printPlayerStartRating(Player player){
        System.out.println(player.getRating() + ". Name: " + player.getName() + "; Team: " + player.getTeam() + "; Age " + player.getAge() + ";");
    }
}
