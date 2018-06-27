package com.lessons;

import java.util.*;

public class FootballManager {
    List<FootballPlayer> listOfPlayers;
    List<FootballTeam> listOfTeams;

    FootballManager(){
        listOfTeams = new ArrayList<FootballTeam>();
        listOfPlayers = new ArrayList<FootballPlayer>();
    }

    public void addNewTeam(Scanner enterText){
        if(enterText.hasNext()) {
            String enter = enterText.nextLine();
            StringTokenizer sT = new StringTokenizer(enter, " ");
            String nTeam = "";
            String tInstr = "";
            String cTeam = "";
            while (sT.hasMoreTokens()) {
                nTeam = sT.nextToken();
                tInstr = sT.nextToken();
                cTeam = sT.nextToken();

            }

                FootballTeam newTeam = new FootballTeam(nTeam, tInstr, cTeam);
                listOfTeams.add(newTeam);

        }
    }


    public void addNewPlayer(String enter){
        StringTokenizer st = new StringTokenizer(enter);
        while(st.hasMoreTokens()){
            String nameOfPlayer = st.nextToken();
            Integer ageOfPlayer = Integer.parseInt(st.nextToken());
            Double ratingOf = Double.parseDouble(st.nextToken());
            String teamOf = st.nextToken();
            FootballTeam fTeam = null;
            for (FootballTeam ft: listOfTeams) {
                if(teamOf.equals(ft.getNameOfTeam())){
                     fTeam = ft;
                }
            }
            if(fTeam.equals(null)){System.out.println("Error. No team is chosen");}
            FootballPlayer newPlayer = new FootballPlayer(nameOfPlayer,ageOfPlayer,ratingOf,fTeam);
            listOfPlayers.add(newPlayer);

        }

    }

    public void uniquePlayes(){
        Set<FootballPlayer> setOfPlayers = new HashSet<FootballPlayer>(listOfPlayers);
        for(FootballPlayer fp: setOfPlayers){
            System.out.println(fp.toString());
        }
    }

    public void sortedByRating(){
        Comparator<FootballPlayer> comparator = new FootballPlayerCompare();
        PriorityQueue <FootballPlayer> playerPriorityQueue = new PriorityQueue<FootballPlayer>(comparator);
        for(FootballPlayer fp: listOfPlayers){
            playerPriorityQueue.add(fp);
        }
        for(FootballPlayer fq: playerPriorityQueue){
            System.out.println(fq.toString());
        }
    }

    public void playersByTeam(){
        for(FootballTeam fts: listOfTeams){
            System.out.println(fts.getNameOfTeam()+":");
            for(FootballPlayer fp: listOfPlayers){
                if(fp.getTeam().getNameOfTeam().equals(fts.getNameOfTeam())){
                    System.out.println(fp.getName());
                }
            }

        }
    }

    public String game(FootballTeam ft1, FootballTeam ft2){
        Double rating1 = 0d;
        Double rating2 = 0d;
        for(FootballPlayer fp: listOfPlayers){
            if(fp.getTeam().getNameOfTeam().equals(ft1.getNameOfTeam())){
                rating1+=fp.getRating();
            } else if(fp.getTeam().getNameOfTeam().equals(ft2.getNameOfTeam())){
                rating1+=fp.getRating();
            }
        }
        if(rating1>rating2){
            return "Winner is "+ft1.getNameOfTeam();
        } else if(rating1>rating2){
            return "Winner is "+ft2.getNameOfTeam();
        }
        return "it is draw";
    }




}
