package com.lessons;

import java.util.*;

/**
 * Created by Ivan
 */
public class FootballManagerHelper {
    private List<Player> players = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    /**
     * teyhod for run aplication
     */
    public void runAplication() {
        System.out.println("welcome");
        System.out.println("'add'-for add player");
        System.out.println("'delete'-for delete player");
        System.out.println("'unique'-view unique players");
        System.out.println("'team'-for view teams and players");
        System.out.println("'play'-for play teams");
        System.out.println("'q'-for quit");

        while (true) {
            String checkString = scanner.nextLine();

            if (checkString.equals(Commands.ADD_PLAYER.getCommand())) {
                addPlayers();
            } else if (checkString.equals(Commands.UNIQUE_PLAYERS.getCommand())) {
                showUniquePlayers();
            } else if (checkString.equals(Commands.DELETE_PLAYER.getCommand())) {
                deletePlayer();
            } else if (checkString.equals(Commands.SHOW_TEAMS_AND_PLAYERS.getCommand())) {
                showTeamsWithPlayers();
            } else if (checkString.equals(Commands.SHOW_PLAYERS_BY_RATING.getCommand())) {
                showPlayersByRating();
            } else if (checkString.equals(Commands.PLAY_MATCH.getCommand())) {
                playMatch();
            } else if (checkString.equals(Commands.QUIT.getCommand())) {
                System.out.println("finish");
                return;
            }
        }

    }

    /**
     * method add player to list
     */
    private void addPlayers() {
        Player player = new Player();
        System.out.println("enter playr's name");
        player.setName(scanner.nextLine());
        System.out.println("enter player's team");
        player.setTeam(scanner.nextLine());
        System.out.println("enter player's age");
        while (!scanner.hasNextInt()) {
            System.out.println("please enter number");
            scanner.next();
        }
        player.setAge(scanner.nextInt());
        System.out.println("enter player's rating ");
        while (!scanner.hasNextInt()) {
            System.out.println("please enter number");
            scanner.next();
        }
        player.setRating(scanner.nextInt());
        players.add(player);
    }

    /**
     * method for delete player
     */
    private void deletePlayer() {
        while (!scanner.hasNextInt()) {
            System.out.println("enter number");
            scanner.next();
        }
        int number = scanner.nextInt();
        if (number < players.size()) {
            players.remove(number);
        } else {
            System.out.println("enter number from list players");
            deletePlayer();
        }
    }

    /**
     * method show unowue players from list
     */
    private void showUniquePlayers() {
        Set<Player> uniquePlayers = new HashSet<>(players);
        for (Player player : uniquePlayers) {
            System.out.println("----------------------------");
            System.out.println("name - " + player.getName());
            System.out.println("age - " + player.getAge());
            System.out.println("team - " + player.getTeam());
            System.out.println("rating - " + player.getRating());
            System.out.println("----------------------------");
        }
    }

    /**
     * show liost players
     *
     * @param list players
     */
    private void showPlayers(List<Player> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("----------------------------");
            System.out.println("number -" + i);
            System.out.println("name - " + list.get(i).getName());
            System.out.println("age - " + list.get(i).getAge());
            System.out.println("team - " + list.get(i).getTeam());
            System.out.println("rating - " + list.get(i).getRating());
            System.out.println("----------------------------");
        }
    }

    /**
     * methos show players and team
     */
    private void showTeamsWithPlayers() {
        Set<String> teamList = new HashSet<>();
        Set<Player> uniquePlayers = new HashSet<>(players);
        List<Player> uniauePlayersList = new ArrayList<>(uniquePlayers);

        for (Player player : players) {
            teamList.add(player.getTeam());
        }
        for (String team : teamList) {
            System.out.println(team);
            for (Player player : uniauePlayersList) {
                if (player.getTeam().equals(team)) {
                    System.out.println("    " + player.getName() +
                            " rating -" + player.getRating());
                }
            }
        }


    }

    /**
     * show players by rating
     */
    private void showPlayersByRating() {
        Set<Player> uniquePlayer = new HashSet<>(players);
        List<Player> uniauePlayersList = new ArrayList<>(uniquePlayer);
        uniauePlayersList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getRating() == p2.getRating()) return 0;
                else if (p1.getRating() > p2.getRating()) return 1;
                else return -1;
            }
        });
        showPlayers(uniauePlayersList);
    }

    /**
     * play match
     */
    private void playMatch() {
        List<Player> command1 = new ArrayList<>();
        List<Player> command2 = new ArrayList<>();
        int ratingFirstTeam = 0;
        int ratingSecondTeam = 0;
        System.out.println("write name first team");
        String nameFirstTeam = scanner.nextLine();
        System.out.println("write name second team");
        String nameSecondTeam = scanner.nextLine();

        for (Player player : players) {
            if (player.getTeam().equals(nameFirstTeam)) {
                ratingFirstTeam += player.getRating();
                command1.add(player);
            }
            if (player.getTeam().equals(nameFirstTeam)) {
                ratingSecondTeam += player.getRating();
                command2.add(player);
            }
        }
        if (command1.size() == 0) {
            System.out.println(nameFirstTeam + "doesn't have players");
            return;
        }
        if (command2.size() == 0) {
            System.out.println(nameSecondTeam + "doesn't have players");
            return;
        }

        if (ratingFirstTeam == ratingSecondTeam) {
            System.out.println("draw");
        }
        if (ratingFirstTeam < ratingSecondTeam) {
            System.out.println("win" + command2.get(0).getTeam());
        }
        if (ratingFirstTeam > ratingSecondTeam) {
            System.out.println("win" + command1.get(0).getTeam());
        }
    }
}
