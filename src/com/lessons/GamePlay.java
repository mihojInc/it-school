package com.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * This class describe Football managed.
 */
public class GamePlay {

    /**
     * sc for save Scanner answer
     */
    Scanner sc;
    /**
     * List of player wich can play football
     */
    private ArrayList<Player> players = new ArrayList<Player>();
    /**
     * List of team wich can play football
     */
    private ArrayList<Team> teams = new ArrayList<Team>();

    GamePlay(Scanner sc) {

        this.sc = sc;
    }

    /**
     * Main method wich conteins ask and answer of user.
     */
    public void playGame() {

        boolean exit = false;//variable for save if we want to exit
        while (true) {//mail application loop. Executing while we in the game

            if (exit) break;//if we want to exit

            //print list of application command
            for (Command cmd : Command.values()) {
                System.out.println(cmd.getComm());
            }
            //Read the answer and check
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Incorrect!");
            }
            int ans = sc.nextInt();
            if (ans > 10) continue;

            //executing users choise
            switch (Command.values()[ans - 1]) {
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
                    Match();
                    break;

                case EXIT:
                    exit = true;
                    break;

                default:
                    System.out.println("Incorect choise");
            }

        }
    }

    /**
     * print list of players to console
     *
     * @param players
     */
    public void listPlayer(ArrayList<Player> players) {

        Iterator<Player> itr = players.iterator();
        //check if the lisp of players is empty
        if (!itr.hasNext()) {
            System.out.println("List is empty");
            return;
        }

        int i = 0;//variable for iteration in ptint 1.2.3...
        while (itr.hasNext()) {
            System.out.println(i + " " + itr.next().toString());
            i++;
        }
    }

    /**
     * print list of teams to console
     *
     * @param teams
     */
    public void listTeam(ArrayList<Team> teams) {

        Iterator<Team> itr = teams.iterator();
        //check if the list of teams is empty
        if (!itr.hasNext()) {
            System.out.println("List is empty");
            return;
        }

        Team curPos;
        int i = 0;//variable for iteration in ptint 1.2.3...
        while (itr.hasNext()) {
            System.out.println(i + " " + itr.next().toString());
            i++;

        }
    }

    /**
     * Add new players
     *
     * @return
     */
    public void addPlayers() {


        //Ask about player settings name, age, rank, team, cost
        System.out.println("Enter name of new player");

        String name = sc.nextLine();

        while (name.equals(""))//check if the answer is correct
            name = sc.nextLine();

        System.out.println("Enter birthday player");
        String birth = sc.nextLine();

        System.out.println("Enter rank player");

        while (!sc.hasNextInt()) {//check if the answer is correct
            sc.next();
            System.out.println("Incorrect!");

        }
        int rank = sc.nextInt();

        System.out.println("Enter team player");
        String teamName = sc.nextLine();

        while (teamName.equals(""))//check if the answer is correct
            teamName = sc.nextLine();


        Team team = chekTeam(teamName);//check if the team is exist
        if (team == null) {//if this team is not exist - we can create new one
            System.out.println("No team with this name. Add new team y/n");
            if (sc.nextLine().equals("y")) {
                addTeam();//create new team;
                team = chekTeam(teamName);

            }

        }

        System.out.println("Enter player cost ");
        while (!sc.hasNextDouble()) {//check if the answer is correct
            sc.next();
            System.out.println("Incorrect!");

        }
        double cost = sc.nextDouble();
        //create new player
        Player newPlayer = new Player(name, birth, rank, team, cost);
        if (team != null)//if we created new team, join player to this team
            team.addPlayer(newPlayer);
        players.add(newPlayer);//add in list

    }

    /**
     * Delete player from list
     */
    public void delPlayer() {

        Iterator<Player> itr = players.iterator();
        //check if the list of teams is empty
        if (!itr.hasNext()) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Chose player for delete");
        listPlayer(this.players);//print list of players for delete
        int delPos = sc.nextInt();
        while (delPos > players.size()) {//check correct answer
            System.out.println("Incorrect");
            delPos = sc.nextInt();
        }
        //delete player from team
        players.get(delPos).getTeam().deletePlayers(players.get(delPos));
        //delete player from list
        players.remove(delPos);

    }

    /**
     * add new team in list
     *
     * @return
     */
    public void addTeam() {
        //Ask about team settings name, money
        System.out.println("Enter name of team");

        String name = sc.nextLine();

        while (name.equals(""))
            name = sc.nextLine();

        if (chekTeam(name) != null) {
            System.out.println("This team is already exist");

        }


        System.out.println("Enter money team");


        while (!sc.hasNextDouble()) {
            sc.next();
            System.out.println("Incorrect!");

        }
        double money = sc.nextDouble();
        //add team
        teams.add(new Team(name, money));


    }

    /**
     * change team where play player
     */
    public void changeTteam() {

        //check if the lisp of players or teams is empty
        Iterator<Player> itrP = players.iterator();

        if (!itrP.hasNext()) {
            System.out.println("List players is empty");
            return;
        }
        Iterator<Team> itrT = teams.iterator();

        if (!itrT.hasNext()) {
            System.out.println("List team is empty");
            return;
        }


        //print list of players for chiose who wnat to change team
        System.out.println("Choise players for change");
        listPlayer(this.players);

        while (!sc.hasNextInt()) {//check if the answer is correct
            sc.next();
            System.out.println("Incorrect!");
        }
        int chPlayer = sc.nextInt();
        if (chPlayer > players.size()) {
            System.out.println("Incorrect");
            return;
        }
        //print list of teams for change
        System.out.println("Choise team");
        listTeam(this.teams);

        while (!sc.hasNextInt()) {//check if the answer is correct
            sc.next();
            System.out.println("Incorrect!");
        }
        int chTeam = sc.nextInt();
        if (chTeam > players.size()) {
            System.out.println("Incorrect");
            return;
        }

        //get team and player
        Player pl = players.get(chPlayer);
        Team tm = teams.get(chTeam);
        //replase team in player
        pl.setTeam(tm);
        //add player in the team
        tm.addPlayer(pl);

    }

    /**
     * Chek if th eteam is esist. If exist return team link, another way NULL
     *
     * @param team
     * @return
     */
    public Team chekTeam(String team) {
        Iterator<Team> itr = teams.iterator();

        Team curPos;
        while (itr.hasNext()) {
            curPos = itr.next();
            if (team.equals(curPos.getNameTeam()))
                return curPos;
        }
        return null;
    }

    /**
     * Sorting list of players using TreeSet
     */
    public void sortPlayers() {
        Iterator<Player> itr = players.iterator();

        if (!itr.hasNext()) {
            System.out.println("List players is empty");
            return;
        }
        TreeSet<Player> sortPlayerTree = new TreeSet<Player>(players);
        ArrayList<Player> sortPlayer = new ArrayList<Player>(sortPlayerTree);
        listPlayer(sortPlayer);
    }

    /**
     * Sorting list of teams using TreeSet
     */
    public void sortTeam() {
        Iterator<Team> itr = teams.iterator();

        if (!itr.hasNext()) {
            System.out.println("List team is empty");
            return;
        }
        TreeSet<Team> sortTeamTree = new TreeSet<Team>(teams);
        ArrayList<Team> sortTeam = new ArrayList<Team>(sortTeamTree);
        listTeam(sortTeam);
    }

    /**
     * Play mach
     */
    public void Match() {
        Iterator<Player> itrP = players.iterator();
        //check if the lisp of players or teams is empty
        if (!itrP.hasNext()) {//
            System.out.println("List players is empty");
            return;
        }
        Iterator<Team> itrT = teams.iterator();

        if (!itrT.hasNext()) {
            System.out.println("List team is empty");
            return;
        }
        //ask for chose team 1 for the game
        System.out.println("Choise team 1");
        listTeam(teams);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        Team t1 = teams.get(sc.nextInt());
        //ask for chose team 2 for the game
        System.out.println("Choise player 2 ");
        listTeam(teams);
        while (!sc.hasNextInt()) {
            sc.next();
        }
        Team t2 = teams.get(sc.nextInt());
        //compare players rank in competitors
        if (t1.rank() < t2.rank()) {
            System.out.println("Winner team " + t2.getNameTeam());
        } else if (t1.rank() > t2.rank()) {
            System.out.println("Winner team " + t1.getNameTeam());
        } else {
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