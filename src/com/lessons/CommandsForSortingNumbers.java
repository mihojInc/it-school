package com.lessons;

public enum CommandsForSortingNumbers {
    //Constants
    SORT_ASCENDING("A"), //Сортировка по возрастанию
    SORT_DECREASING("D"), //Сортировка по убыванию
    QUIT("Q"); //Выйти из приложения

    //Fields
    private String commandName;

    //Constructor
    CommandsForSortingNumbers(String commandName) {
        this.commandName = commandName;
    }

    //Getters
    public String getCommandName() {
        return commandName;
    }
}
