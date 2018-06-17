package com.lessons;

import java.util.*;

/**
 * All operation with players and teams;
 */
public class Football {

    /**
     * List teams. Default init Street team.
     */
    private ArrayList<String> teams = new ArrayList<>(Arrays.asList("Street"));

    public Player addPlayer(Scanner scanner) {
        Player player = new Player();

        System.out.println("Player name:");
        player.setName(scanner.nextLine());


        try {
            System.out.println("Player age:");
            byte age = Byte.valueOf(scanner.nextLine());
            System.out.println("Select " + player.getName() + "'s rang:");
            int rang = Integer.valueOf(scanner.nextLine());

            player.setAge(age);
            player.setRang(rang);
        } catch (NumberFormatException nfe) {
            //
        }

        System.out.println("Select team or create own:\n");

        int i = 1;
        for (String team : teams)
            System.out.print(i++ + " - " + team + " ");

        String team = scanner.nextLine();

        try {
            int teamPosition = Integer.valueOf(team);
            if (teamPosition > i || teamPosition < 0)
                team = teams.get(0);     //default player from street
            else
                team = teams.get(teamPosition - 1);

        } catch (NumberFormatException e) {
            teams.add(team);
        }

        player.setTeam(team);

        return player;
    }

    /**
     * @return - String name of team from List of teams with scanner input (index - 1)
     */
    public String getTeamByIndex(Scanner scanner) {

        try {
            int teamNumber = Integer.valueOf(scanner.nextLine());
            if (teamNumber <= teams.size() & teamNumber > 0)
                return teams.get(teamNumber - 1);
            else
                return teams.get(0);
        } catch (NumberFormatException nfe) {
            return teams.get(0);
        }
    }

    /**
     * powerTeam - is sum of rang all players of team
     *
     * @return string represent result of football match (f.e. 4:2)
     */
    public String resultByPower(int powerFirstTeam, int powerSecondTeam) {

        // primitive interprertate real game
        int resultFirstTeam = powerFirstTeam / 5;
        int resultSecondTeam = powerSecondTeam / 5;
        while (resultFirstTeam > 4 | resultSecondTeam > 4) {
            resultFirstTeam /= 5;
            resultSecondTeam /= 5;
        }

        if (resultFirstTeam == resultSecondTeam) {
            if (powerFirstTeam > powerSecondTeam)
                resultFirstTeam++;
            else
                resultSecondTeam++;
        }
        return resultFirstTeam + ":" + resultSecondTeam;
    }

    /**
     * Add some players
     *
     * @return Set of real football players
     */
    public Set addFewPlayers() {
        teams.add("Metallist");
        teams.add("Barselona");
        teams.add("Bayer");

        Set<Player> patch = new HashSet<>();
        patch.add(new Player("Ermolenko", (byte) 23, teams.get(1), 20));
        patch.add(new Player("Fernando", (byte) 32, teams.get(1), 31));
        patch.add(new Player("Sinitsja", (byte) 25, teams.get(1), 30));
        patch.add(new Player("Messi", (byte) 30, teams.get(2), 75));
        patch.add(new Player("Iniesta", (byte) 30, teams.get(2), 60));
        patch.add(new Player("Paco", (byte) 17, teams.get(2), 47));
        patch.add(new Player("Folland", (byte) 25, teams.get(3), 50));
        patch.add(new Player("Sven", (byte) 29, teams.get(3), 44));
        patch.add(new Player("Lucas", (byte) 25, teams.get(3), 52));
        return patch;
    }

    public ArrayList<String> getTeams() {
        return teams;
    }
}
