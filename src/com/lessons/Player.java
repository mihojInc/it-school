package com.lessons;

import java.util.Objects;

public class Player implements Comparable<Player>{

    //Fields
    private String name; //Имя
    private int age;     //Возраст
    private int rating;  //Рейтинг


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


    //Overridden super class methods
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

    @Override
    public String toString() {
        return "Имя игрока: " + name + " Возраст: " + age + " Рейтинг по FIFA: " + rating;
    }

    /**
     * A redefined method of compareTo Interface Compareble for sorting players by name
     * @param player
     * @return
     */
    @Override
    public int compareTo(Player player) {
        return name.compareTo(player.name);
    }
}
