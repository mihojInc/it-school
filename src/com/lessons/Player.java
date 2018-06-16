package com.lessons;

import java.util.Objects;

public class Player {
    private String name;
    private Integer age;
    private Integer rating;
    private String team;


    public Player(String name, Integer age, Integer rating, String team) {
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.team = team;
    }

    public Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) &&
                Objects.equals(getAge(), player.getAge()) &&
                Objects.equals(getRating(), player.getRating()) &&
                Objects.equals(getTeam(), player.getTeam());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getRating(), getTeam());
    }

}
