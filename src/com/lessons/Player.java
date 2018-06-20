package com.lessons;

import java.util.Date;
import java.util.Objects;

/**
 * describe settings and behavour of players
 */

public class Player implements Comparable<Player> {
    /**
     * Namr of player
     */
    private String name;
    /**
     * date birth player
     */
    private String dateBirth;
    /**
     * rank of players
     */
    private int rank;
    /**
     * team where the players play
     */
    private Team team = null;
    /**
     * cost player
     */
    private double cost;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        if (this.team != null) this.team.deletePlayers(this);
        this.team = team;
    }

    public Player(String name, String dateBirth, int rank, Team team, double cost) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.rank = rank;
        this.team = team;
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", rank=" + rank +
                ", team=" + team.getNameTeam() +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return rank == player.rank &&
                Double.compare(player.cost, cost) == 0 &&
                Objects.equals(name, player.name) &&
                Objects.equals(dateBirth, player.dateBirth) &&
                Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, dateBirth, rank, team, cost);
    }

    @Override
    public int compareTo(Player o) {
        return this.rank - o.rank;
    }

    public int getRank() {
        return rank;
    }

}
