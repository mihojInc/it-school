package com.lessons;

import java.util.Comparator;
import java.util.Objects;

public class Player implements Comparator<Player> {

    //Fields
    private String name; //Имя
    private int age;     //Возраст
    private int rating;  //Рейтинг
    private String team; //Команда

    //Constructor
    public Player(String name, int age, int rating) {
        this.name = name;
        this.age = age;
        this.rating = rating;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTeam() { return team; }

    public void setTeam(String team) { this.team = team; }

    //Overridden super class methods




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getAge() == player.getAge() &&
                getRating() == player.getRating() &&
                Objects.equals(getName(), player.getName()) &&
                Objects.equals(getTeam(), player.getTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getRating(), getTeam());
    }


    @Override
    public String toString() {
        return "Имя: " + name + " Возраст: " + age + " Рейтинг по FIFA: " + rating;
    }


    @Override
    public int compare(Player p1, Player p2) {
        if(p1.getRating() > p2.getRating()) {
            return 1;
        } else if(p1.getRating() < p2.getRating()) {
            return -1;
        } else {
            return 0;
        }
    }
}
