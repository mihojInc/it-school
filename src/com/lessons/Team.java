package com.lessons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * class describe behavour and settings of team
 */
public class Team implements Comparable<Team> {
    /**
     * name team
     */
    private String nameTeam;
    /**
     * available money for bue the players
     */
    private double curMoney = 0.0d;

    /**
     * list of players in the team
     */
    private ArrayList<Player> players = new ArrayList<Player>();

    public Team(String nameTeam, double curMoney) {
        this.nameTeam = nameTeam;
        this.curMoney = curMoney;
    }

    /**
     * add player in the team
     *
     * @param pl
     */
    void addPlayer(Player pl) {
        players.add(pl);
    }

    /**
     * remove players from th eteam
     *
     * @param pl
     */
    void deletePlayers(Player pl) {
        players.remove(pl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Double.compare(team.curMoney, curMoney) == 0 &&
                Objects.equals(nameTeam, team.nameTeam) &&
                Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {

        return nameTeam.hashCode() + (int) curMoney + players.hashCode();
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public double getCurMoney() {
        return curMoney;
    }

    /**
     * calculate summ of players rank
     *
     * @return
     */
    public int rank() {
        int rank = 0;
        Iterator<Player> itr = players.iterator();

        while (itr.hasNext()) {

            rank += itr.next().getRank();
        }
        return rank;
    }

    @Override
    public int compareTo(Team o) {

        return this.rank() - o.rank();
    }

    @Override
    public String toString() {
        String play = "\n\t";
        Iterator<Player> itr = players.iterator();
        while (itr.hasNext()) {
            play = play + itr.next().toString() + "\n\t";
        }
        return "Team{" +
                "nameTeam='" + nameTeam + '\'' +
                ", curMoney=" + curMoney +
                play +
                '}';
    }
}
