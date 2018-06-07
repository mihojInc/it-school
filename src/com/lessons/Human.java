package com.lessons;

/**
 * Create an abstract class for all people
 */
public class Human {
    //Fields
    private String name;
    private Integer age;
    //Constructor

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    //Getters and Setters

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

}

