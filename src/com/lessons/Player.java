package com.lessons;

import java.util.Objects;

/**
 * Created by Ivan
 */
public class Player {


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rating=" + rating +
                ", team='" + team + '\'' +
                '}';
    }

    private String name;

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

    private Integer age;
    private Integer rating;
    private String team;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age &&
                rating == player.rating &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, rating);
    }
}
