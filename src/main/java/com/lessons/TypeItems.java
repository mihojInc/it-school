package com.lessons;

public enum TypeItems {
    MILK("Milk"),
    MEET("Meet"),
    FISH ("Fish");

    private String name;

    public String getName() {
        return name;
    }

    TypeItems(String name) {
        this.name = name;
    }
}