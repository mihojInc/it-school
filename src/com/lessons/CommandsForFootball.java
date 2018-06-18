package com.lessons;

public enum CommandsForFootball {

    //Fields
    ADD_PLAYERS("1"), //Создать игроков и длбавить их в коллекцию
    SHOW_PLAYERS_RATING("2"), //Показать игроков по рейтингу
    SHOW_UNIQUE_PLAYERS("3"), //Показать уникальных игроков
    REMOVE_PLAYERS("4"), //Удалить игрока из коллекции
    SHOW_PLAYERS_BY_TEAMS("5"), //Показать игроков по командам
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
