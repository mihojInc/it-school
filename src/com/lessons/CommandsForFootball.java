package com.lessons;

public enum CommandsForFootball {

    //Fields
    CREATE_TEAM_ONE("1"), //Создать первую команду
    CREATE_TEAM_TOO("2"), //Создать вторую команду
    SHOW_PLAYERS("3"), //Показать игроков по рейтингу
    SHOW_UNIQUE_PLAYERS("4"), //Показать уникальных игроков
    REMOVE_PLAYERS("5"), //Удалить игрока из коллекции
    PLAY_THE_MATCH("6"), //Сыграть матч
    QUIT("Q"); //Выйти из игры

    private String commandName;

    //Constructor
    CommandsForFootball(String commandName) {
        this.commandName = commandName;
    }

    //Getters
    public String getCommandName() {
        return commandName;
    }

    /**
     * The method that checks the input of a command
     * @param string
     * @return
     */
    public static CommandsForFootball getCommand(String string) {
        if (string != null) {
            for (CommandsForFootball commands : values()) {
                if (commands.getCommandName().equals(string)) {
                    return commands;
                }
            }
        }
        return null;
    }
}
