package com.lessons;

import java.util.*;

public class FootballManager {

    PlayerManager playerManager = new PlayerManager();

    /**
     * Function in which the game starts
     *
     * @param scanner
     */
    public void startGame(Scanner scanner) {
        while (true) {
            showFootballManager();
            if (scanner.hasNext()) {
                CommandsForFootball command = CommandsForFootball.getCommand(scanner.next());
                if (command == null) {
                    continue;
                }
                switch (command) {
                    case ADD_PLAYERS:
                        playerManager.addPlayers(scanner);
                        System.out.println(" ");
                        break;
                    case SHOW_PLAYERS_RATING:
                        playerManager.showPlayersByRating();
                        System.out.println(" ");
                        break;
                    case SHOW_UNIQUE_PLAYERS:
                        playerManager.showUniquePlayers();
                        System.out.println(" ");
                        break;
                    case REMOVE_PLAYERS:
                        playerManager.removePlayers(scanner);
                        System.out.println(" ");
                        break;
                    case SHOW_PLAYERS_BY_TEAMS:
//                        playerManager.sortingPlayersByTeams();
//                        playerManager.aLotOfTeamsWithPlayers();
                        playerManager.sortingPlayersIntoTeams();
                        System.out.println(" ");
                        break;
                    case PLAY_THE_MATCH:
                        playerManager.playMatch(scanner);
                        System.out.println(" ");
                        break;
                    case QUIT: {
                        playerManager.finishProgramm();
                        System.exit(0);
                        return;
                    }
                    default:
                        continue;
                }
            }
        }
    }

    /**
     * Method greeting with the user
     */
    public void showFootballManager() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ФУТБОЛЬНЫЙ МЕНЕДЖЕР!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Сперва создайте игроков! Для этого нажмите: " + CommandsForFootball.ADD_PLAYERS.getCommandName());
        System.out.println("Отсортировать игроков по рейтингу, нажмите: " + CommandsForFootball.SHOW_PLAYERS_RATING.getCommandName());
        System.out.println("Посмотреть список уникальных игроков, нажмите: " + CommandsForFootball.SHOW_UNIQUE_PLAYERS.getCommandName());
        System.out.println("Что бы удалить игрока из списка, нажмите: " + CommandsForFootball.REMOVE_PLAYERS.getCommandName());
        System.out.println("Что бы поделить игроков на команды, нажмите: " + CommandsForFootball.SHOW_PLAYERS_BY_TEAMS.getCommandName());
        System.out.println("Сыграть между командами матч, нажмите: " + CommandsForFootball.PLAY_THE_MATCH.getCommandName());
        System.out.println("Что бы выйти из игры, нажмите: " + CommandsForFootball.QUIT.getCommandName());
    }

}
