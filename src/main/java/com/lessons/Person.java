package com.lessons;

/**
 * Created by Mihail Kolomiets on 18.07.18.
 */
public class Person {
    private long id;
    private String name;
    private Role role;
    private int age;

    private static long idCount = 0;

    public Person(String name, Role role, int age) {
        id = ++idCount;
        this.name = name;
        this.role = role;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Id " + id + " - name " + name + " - role " + role.name().toLowerCase() + " - age " + age;
    }
}
