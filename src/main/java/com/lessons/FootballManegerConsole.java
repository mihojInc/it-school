package main.java.com.lessons;

import java.util.*;


/**
 *
 */
public class FootballManegerConsole {

    private Scanner scanner = new Scanner(System.in);
    private Football football = new Football();

    private Set<Player> players = new HashSet<>();

    public void startManeger() {

        ConsoleCommand commandFromUser = ConsoleCommand.N0_COMMAND;

        players.addAll(football.addFewPlayers());
        System.out.println("Welcome. Select action:");
        getHelp();

        while (commandFromUser != ConsoleCommand.Q) {

            //himself change
            commandFromUser = commandFromUser.parse(scanner.nextLine());

            switch (commandFromUser) {
                case N0_COMMAND:
                    System.out.println("Incorrect command ");
                    break;

                //get info about console comand
                case H:
                    getHelp();
                    break;

                //add new player in set
                case A:
                    Player player = football.addPlayer(scanner);
                    if (players.add(player))
                        System.out.println("Team " + player.getTeam() + " success add " + player.getName());
                    break;

                // show sorted by rang player in console
                case VS:
                    List<Player> sortList = new ArrayList<>(players);

                    //https://stackoverflow.com/questions/5789503/java-comparator-using-reverseorder-but-with-an-inner-class
                    sortList.sort(Comparator.comparingInt(Player::getRang).reversed());

                    System.out.println(" name - age - team - rang");
                    for (Player p : sortList) {
                        System.out.println(p.getName() + " - " + p.getAge() + " - " + p.getTeam() + " - " + p.getRang());
                    }
                    break;

                // show player in console
                case V:
                    System.out.println(" name - age - team - rang");
                    for (Player p : players) {
                        System.out.println(p.getName() + " - " + p.getAge() + " - " + p.getTeam() + " - " + p.getRang());
                    }
                    break;

                //delete player
                case D:
                    List<Player> playerList = new LinkedList<>(players);
                    int playerNumber = 1;
                    System.out.println("That is number delete?");
                    for (Player p : players) {
                        System.out.println(playerNumber++ + " " + p.getName());
                    }

                    try {
                        playerNumber = Integer.valueOf(scanner.nextLine());
                        if (playerNumber > 0 | playerNumber <= playerList.size()) {
                            Player deletedPlayer = playerList.remove(--playerNumber);
                            players = new HashSet<>(playerList);
                            System.out.println(deletedPlayer.getName() + " was deleted. Team " + deletedPlayer.getTeam()
                                    + " lost " + deletedPlayer.getRang() + " team power.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Sorry. Delete has failed.");
                    }
                    break;

                //play 2 team football match
                case P:
                    String firstTeam, secondTeam;
                    int powerFirstTeam, powerSecondTeam;
                    List<String> team = football.getTeams();

                    if (team.size() > 1) {
                        System.out.println("Select 2 teams:\n" +
                                "number - team");
                        int numberTeam = 1;
                        for (String teamName : team)
                            System.out.println(numberTeam++ + " - " + teamName);

                        firstTeam = football.getTeamByIndex(scanner);
                        secondTeam = football.getTeamByIndex(scanner);

                        if (firstTeam.equals(secondTeam))
                            firstTeam = secondTeam.equals(team.get(0)) ? team.get(1) : team.get(0);

                        powerFirstTeam = powerSecondTeam = 0;
                        for (Player p : players) {
                            if (p.getTeam().equals(firstTeam)) {
                                powerFirstTeam += p.getRang();
                            } else if (p.getTeam().equals(secondTeam)) {
                                powerSecondTeam += p.getRang();
                            }
                        }

                        System.out.println(firstTeam + "(" + powerFirstTeam + ") " +
                                football.resultByPower(powerFirstTeam, powerSecondTeam)
                                + " " + secondTeam + "(" + powerSecondTeam + ")");

                    } else {
                        System.out.println("Sorry. Only 1 team.");
                    }
                    break;
            }
        }
    }

    /**
     * Print in console possible commands
     */
    private void getHelp() {
        String info = "";

        for (ConsoleCommand c : ConsoleCommand.values()) {
            if (c.getValue() != null)
                info += c.getValue() + " - " + c.getDescription() + ", ";
        }
        System.out.println(info.substring(0, info.length() - 2));
    }

}
