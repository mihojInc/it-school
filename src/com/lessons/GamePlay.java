package com.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class GamePlay {


    Scanner sc;
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Team> teams = new ArrayList<Team>();

    GamePlay(Scanner sc){

        this.sc = sc;
    }


    public void playGame(){

       boolean exit = false;
       while (true){

           if(exit)break;

           for (Command cmd:Command.values()){
               System.out.println(cmd.getComm());
           }

           while(!sc.hasNextInt()){
               sc.next();
               System.out.println("Incorrect!");
           }
           int ans = sc.nextInt();

           if(ans>10)continue;

           switch (Command.values()[ans-1] ){
                   case LIST_PLAYERS:
                       listPlayer(this.players);
                    break;

                   case LEADERS_PLAYERS:
                       sortPlayers();
                       break;

                   case ADD_PLAYER:
                       addPlayers();
                       break;

                   case ADD_TEAM:
                       addTeam();
                       break;

                   case DELETE_PLAYER:
                       delPlayer();
                       break;

                   case CHANGE_TEAM:
                       changeTteam();
                       break;

                   case LIST_TEAM:
                       listTeam(this.teams);
                       break;

                   case LIST_TEAM_LEAD:
                       sortTeam();
                       break;

                   case PLAY_GAME:
                        playGame();
                       break;

                   case EXIT:
                        exit = true;
                        break;

                   default:
                       System.out.println("Incoorect choise");
                   }

               }
           }

    public void listPlayer(ArrayList<Player> players) {

        Iterator<Player> itr = players.iterator();

        if (!itr.hasNext()){
            System.out.println("List is empty");
            return;
        }

        Player curPos;
        int i = 0;
        while (itr.hasNext()) {
            System.out.println(i + " " + itr.next().toString());
            i++;
        }
    }

    public void listTeam(ArrayList<Team>  teams) {

        Iterator<Team> itr = teams.iterator();

        if (!itr.hasNext()){
            System.out.println("List is empty");
            return;
        }

        Team curPos;
        int i = 0;
        while (itr.hasNext()) {
            System.out.println(i + " " + itr.next().toString());
            i++;

        }
    }

    public boolean addPlayers(){

        Team team = null;


        System.out.println("Enter name of new player");

        String name = sc.nextLine();

        while (name.equals(""))
            name = sc.nextLine();

        System.out.println("Enter birthday player");
        String birth = sc.nextLine();

        System.out.println("Enter rank player");

        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("Incorrect!");

        }
        int rank = sc.nextInt();

        System.out.println("Enter team player");
        String teamName = sc.nextLine();

        while (teamName.equals(""))
            teamName = sc.nextLine();


        team =chekTeam(teamName);
        if(team==null){
            System.out.println("No team with this name. Add new team y/n");
            if(sc.nextLine().equals("y")){
                addTeam();
                team =chekTeam(teamName);


            }else{
                return false;
            }

        }

        System.out.println("Enter player cost ");
        while(!sc.hasNextDouble()){
            sc.next();
            System.out.println("Incorrect!");

        }
        double cost = sc.nextDouble();

        players.add(new Player(name, birth, rank, team, cost));
        return true;
    }

    public void delPlayer(){

        Iterator<Player> itr = players.iterator();

        if (!itr.hasNext()){
            System.out.println("List is empty");
            return;
        }

        System.out.println("Chose player for delete");
        listPlayer(this.players);
        int delPos = sc.nextInt();
        while (delPos>players.size()){
            System.out.println("Incorrect");
            delPos = sc.nextInt();
        }

        players.remove(delPos);

    }

    public  boolean addTeam(){
        System.out.println("Enter name of team");


        String name = sc.nextLine();

        while (name.equals(""))
            name = sc.nextLine();

        if(chekTeam(name)!=null){
            System.out.println("This team is already exist");
            return false;
        }


        System.out.println("Enter money team");


        while(!sc.hasNextDouble()){
            sc.next();
            System.out.println("Incorrect!");

        }
        double money = sc.nextDouble();

        teams.add(new Team(name, money));

        return true;
    }

    public void changeTteam(){

        Iterator<Player> itrP = players.iterator();

        if (!itrP.hasNext()){
            System.out.println("List players is empty");
            return;
        }
        Iterator<Team> itrT = teams.iterator();

        if (!itrT.hasNext()){
            System.out.println("List team is empty");
            return;
        }



        System.out.println("Choise players for change");
        listPlayer(this.players);
        int chPlayer = sc.nextInt();
        System.out.println("Choise team");
        listTeam(this.teams);
        int chTeam = sc.nextInt();

        Player pl = players.get(chPlayer);
        Team tm = teams.get(chTeam);
        pl.setTeam(tm);
        tm.addPlayer(pl);

    }

    public Team chekTeam(String team){
        Iterator<Team> itr = teams.iterator();


        Team curPos;
        while (itr.hasNext()) {
            curPos = itr.next();
            if(team.equals(curPos.getNameTeam()))
                return curPos;
        }
        return null;
    }

    public void sortPlayers(){
        Iterator<Player> itr = players.iterator();

        if (!itr.hasNext()){
            System.out.println("List players is empty");
            return;
        }
        TreeSet<Player> sortPlayerTree = new TreeSet<Player>(players);
        ArrayList<Player> sortPlayer = new ArrayList<Player>(sortPlayerTree);
        listPlayer(sortPlayer);
    }

    public void sortTeam(){
        Iterator<Team> itr = teams.iterator();

        if (!itr.hasNext()){
            System.out.println("List team is empty");
            return;
        }
        TreeSet<Team> sortTeamTree = new TreeSet<Team>(teams);
        ArrayList<Team> sortTeam= new ArrayList<Team>(sortTeamTree);
        listTeam(sortTeam);
    }

    public void PlayGame(){
        Iterator<Player> itrP = players.iterator();

        if (!itrP.hasNext()){
            System.out.println("List players is empty");
            return;
        }
        Iterator<Team> itrT = teams.iterator();

        if (!itrT.hasNext()){
            System.out.println("List team is empty");
            return;
        }

        System.out.println("Choise team 1");
        listTeam(teams);
        while(!sc.hasNextInt()){
            sc.next();
        }
        Team t1 = teams.get(sc.nextInt());

        System.out.println("Choise player 2 ");
        listTeam(teams);
        while(!sc.hasNextInt()){
            sc.next();
        }
        Team t2 = teams.get(sc.nextInt());

         if (t1.rank()< t2.rank()){
             System.out.println("Winner team " + t2.getNameTeam());
         }else
             if(t1.rank()> t2.rank()){
             System.out.println("Winner team " + t1.getNameTeam());
         } else{
                 System.out.println("Draw");
         }

    }

//    public Iterator checkAvail(T obj){
//        Iterator<T> itr = obj.iterator();
//
//        if (!itr.hasNext()){
//
//            return null;
//        }
//        return itr;
//    }
}