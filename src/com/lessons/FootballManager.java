package com.lessons;

import java.util.*;

public class FootballManager {
    private static final int MAX_SIZE_PLAYER = 3;
    private static final int SIZE_FOR_LOOP = 4;
    private static List<Player> playerList = new ArrayList<>(MAX_SIZE_PLAYER);
    private static List<Player> playerList2 = new ArrayList<>(MAX_SIZE_PLAYER);
    //Коллекция с уникальными игроками
    private static Set<Player> playerSet = new HashSet<>(playerList);
    private static Set<Player> playerSet2 = new HashSet<>(playerList2);


    /**
     * Function in which the game starts
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
                    case CREATE_TEAM_ONE: {
                        createTeamOne(scanner);
                        System.out.println(" ");
                        break;
                    }
                    case CREATE_TEAM_TOO:
                        createTeamTwoo(scanner);
                        System.out.println(" ");
                        break;
                    case SHOW_PLAYERS :
                        showPlayersByRating();
                        System.out.println(" ");
                        break;
                    case PLAY_THE_MATCH :

                        System.out.println(" ");
                        break;
                    case QUIT: {
                        finishProgramm();
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
        System.out.println("Здравствуйте! Вас приветствует футбольный менеджер!");
        System.out.println("Создайте первую команду, нажмите: " + CommandsForFootball.CREATE_TEAM_ONE.getCommandName());
        System.out.println("Создайте вторую команду, нажмите: " + CommandsForFootball.CREATE_TEAM_TOO.getCommandName());
        System.out.println("Просмотреть игроков в командах: " + CommandsForFootball.SHOW_PLAYERS.getCommandName());
        System.out.println("Сыграть между командами матч, нажмите: " + CommandsForFootball.PLAY_THE_MATCH.getCommandName());
        System.out.println("Что бы выйти из игры, нажмите: " + CommandsForFootball.QUIT.getCommandName());
    }


    /**
     * The method in which the first command is created
     * @param scanner
     */
    public void createTeamOne(Scanner scanner) throws InputMismatchException{
//        System.out.println("Придумайте название команды: ");
//        player.setTeamName(scanner.next());
//        System.out.println("Прекрасно! А теперь наберите в свою команду 5 игроков!");
        for (int i = 1; i < SIZE_FOR_LOOP; i++) {
            Player player = new Player();
            System.out.println("Сoздайте игрока: " + i);
            System.out.print("Введите имя игрока: ");
            player.setName(scanner.next());
            System.out.print("Введите возраст игрока: ");
            player.setAge(scanner.nextInt());
            System.out.print("Введите рейтинг игрока по FIFA: ");
            player.setRating(scanner.nextInt());
            playerList.add(player);
        }

        System.out.println("В команде \"A\": ");
        for (Player p : playerList) {
            System.out.println(p);
        }

    }

    /**
     * The method in which the second command is created
     * @param scanner
     */
    public void createTeamTwoo(Scanner scanner) throws InputMismatchException{
        for (int i = 1; i < SIZE_FOR_LOOP; i++) {
            Player player = new Player();
            System.out.println("Сoздайте игрока: " + i);
            System.out.print("Введите имя игрока: ");
            player.setName(scanner.next());
            System.out.print("Введите возраст игрока: ");
            player.setAge(scanner.nextInt());
            System.out.print("Введите рейтинг игрока по FIFA: ");
            player.setRating(scanner.nextInt());
            playerList2.add(player);
        }
        System.out.println("В команде \"B\": ");
        for (Player p : playerList2) {
            System.out.println(p);
        }

    }

    /**
     * Метод сравнения игроков
     * //TODO доделать реализацию. все время выпадает else
     * @param playerList
     * @param playerList2
     */
    public void playMatch(List playerList, List playerList2) {
        for (int i = 0; i < playerList.size(); i++) {
            for (int j = 0; j < playerList2.size(); j++) {
                if(playerList.get(i).equals(playerList2.get(j))) {
                    System.out.println("Ничья");
                }else {
                    System.out.println("Победила команда: ");
                }
            }
        }
    }

    /**
     * The method in which players are sorted by rating
     */
    public void showPlayersByRating() {
        System.out.println("Игроки команды \"A\" по рейтингу");
        //Сортировка игроков по рейтингу через Comparator
        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getRating() == p2.getRating()) return 0;
                else if (p1.getRating() > p2.getRating()) return 1;
                else return -1;
            }
        });
        playerList.forEach(System.out::println);
        System.out.println(" ");

        System.out.println("Игроки команды \"B\" по рейтингу");
        //Сортировка игроков по рейтингу через Comparator
        playerList2.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getRating() == p2.getRating()) return 0;
                else if (p1.getRating() > p2.getRating()) return 1;
                else return -1;
            }
        });
        playerList2.forEach(System.out::println);
        System.out.println(" ");
    }

    /**
     *Remove Players
     */
    public void removePlayers() {
        //TODO доделать рандомное удаление игрока
    }



    /**
     * Farewell method
     */
    public void finishProgramm() {
        System.out.println("Досвидания!");
    }
}
