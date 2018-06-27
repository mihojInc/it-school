package com.lessons;

import java.util.Objects;

public class FootballPlayer {
    private String name;
    private Integer age;
    private Double rating;
    private FootballTeam team;

   FootballPlayer(String name, int age, double rating, FootballTeam team){
       this.name = name;
       this.age = age;
       this.rating = rating;
       this.team = team;
   }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name " +name+" age: "+age+" rating: "+rating+" team: "+team.getNameOfTeam();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FootballPlayer player = (FootballPlayer) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(age, player.age) &&
                Objects.equals(rating, player.rating) &&
                Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, rating, team);
    }

    public Double getRating() {
        return rating;
    }

    public FootballTeam getTeam() {
        return team;
    }
}
