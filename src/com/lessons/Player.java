package com.lessons;

import java.util.Objects;

/**
 * Class describes football player;
 * Sets name, age, rating and team of player
 */
public class Player {
    private String name;
    private Integer age;
    private Integer rating;
    private String team;

    /**
     * Constructor allows to set name, age, team and rating
     * @param name
     * @param age
     * @param rating
     * @param team
     */
    public Player(String name, Integer age, Integer rating, String team) {
        this.name = name;
        this.age = age;
        this.rating = rating;
        this.team = team;
    }

    /**
     * void constructor
     */
    public Player(){

    }

    /**
     * method for getting name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * method sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method for getting age
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * method sets age
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     *method for getting rating
     * @return
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * method sets rating
     * @param rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     *method for getting team
     * @return
     */
    public String getTeam() {
        return team;
    }

    /**
     * method sets team
     * @param team
     */
    public void setTeam(String team) {
        this.team = team;
    }

    /**
     * overrided equals, include fields to compare
     * @param o
     * @return
     */
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

    /**
     * overrided hashCode, include fields for generating hashCode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getRating(), getTeam());
    }

}
