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

    /**
     * Проверяет если переданная строка равна строке у команды
     * То возращает этот элемент команды
     * @param string
     * @return
     */
    public static CommandsForSortingNumbers getCommand(String string) {
        if (string != null) {
            for (CommandsForSortingNumbers commands : values()) {
                if (commands.getCommandName().equals(string)) {
                    return commands;
                }
            }
        }
        return null;
    }
}
