package com.lessons;

public class People {
    private int id;
    private int age;
    private String name;
    private Role role;

    public People(int id, int age, String name, Role role) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "Топовые разработчики и тестировщики: " + "id:" + id + " Имя:" + "-"+ name + "-" +
                " Возраст:" + "-" + age + "-" + " ROLE:" + "-" + role + "-";
    }
}
