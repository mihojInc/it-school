package com.lessons;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerManager {

    private List<Player> playerList = new ArrayList<>();
    //Две команды игроков
    private List<Player> commandOne = new ArrayList<>();
    private List<Player> commandTwo = new ArrayList<>();

    //Constructor
    public List<Player> getPlayerList() { return playerList; }

    //Getters and Setters
    public List<Player> getCommandOne() {
        return commandOne;
    }

    public List<Player> getCommandTwo() {
        return commandTwo;
    }

    /**
     * The method in which players are created, and added to the collection
     * @param scanner
     */
    public void addPlayers(Scanner scanner) throws InputMismatchException {
        String name, team;
        int age, rating;
        while (true) {
            System.out.println("Сoздайте игрока! Для выхода нажмите \"q\"");
            System.out.print("Введите имя игрока: ");
            name = scanner.next();
            if (name.equals("q")) break;
            System.out.print("Введите возраст игрока: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Введите возраст игрока цифрами: ");
                scanner.next();
            }
            age = scanner.nextInt();
            System.out.print("Введите рейтинг игрока по FIFA: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Введите рейтинг игрока цифрами: ");
                scanner.next();
            }
            rating = scanner.nextInt();
            System.out.print("Введите имя команды: ");
            team = scanner.next();

            playerList.add(new Player(name, age, rating, team));
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Игроки которых вы создали!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Player player : playerList) {
            System.out.println(player);
        }
    }

//    /**
//     * TODO The method that checks for identical names
//     * @param name
//     * @return
//     */
//    private boolean isUniqueNamePlayers(String name) {
//        for (Player item : playerList) {
//            if (item.getName().equals(name)) {
//                System.out.println("Такой игрок уже есть!");
//                return false;
//            }
//        }
//        return true;
//    }

    /**
     * The method in which players are sorted by rating
     */
    public void showPlayersByRating() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Список футболистов по рейтингу");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //Сортировка игроков по рейтингу через Comparator
        playerList.sort(new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                if (p1.getRating() == p2.getRating()) {
                    return 0;
                } else if (p1.getRating() > p2.getRating()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        playerList.forEach(System.out::println);
        System.out.println(" ");
    }

    /**
     * Unique players method
     */
    public void showUniquePlayers() {
        Set<Player> playerSet = new HashSet<>(playerList);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Список уникальных игроков!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Player player : playerSet) {
            System.out.println("Имя игрока: " + player.getName() + " Возраст: " + player.getAge()
                    + " Рейтинг по FIFA: " + player.getRating() + " Команда: " + player.getTeam());
        }

    }

    /**
     * The method in which the player is removed by name
     */
    public void removePlayers(Scanner scanner) {
        System.out.print("Напишите имя игрока, которого хотите удалить: ");
        System.out.println(" ");
        String name = scanner.next();
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getName().equals(name)) playerList.remove(i);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Игроки которые остались после удаления.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Player player : playerList) {
            System.out.println(player);
        }
    }

    /**
     * Method for sorting players by teams
     * //TODO Метод сортировки игроков на две команды больше не нужен
     */
    public void sortingPlayersByTeams() {
        Integer index = 0;
        //Метод shuffle хаотично разбивает коллекцию на два листа
        Collections.shuffle(playerList);
        for (int i = 0; i < playerList.size() / 2; i++) {
            commandOne.add(playerList.get(index++));
            commandTwo.add(playerList.get(index++));
        }
        System.out.println("Команда А: ");
        commandOne.forEach(System.out::println);
        System.out.println("");
        System.out.println("Команда B: ");
        commandTwo.forEach(System.out::println);
    }

    /**
     * //TODO Old parameter List<Player> comm1, List<Player> comm2
     * The method of comparing the two teams by rating
     * @param
     * @param
     */
    public void playMatch(Scanner scanner) {
        String team1, team2;
        int raiting1 = 0 ,raiting2 = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя первой команды!");
        team1 = scan.next();
        System.out.println("Введите имя второй команды!");
        team2 = scan.next();
        for (Player rating : playerList) {
            if (team1.equals(rating.getTeam())) {
                raiting1 += rating.getRating();
            }
            if (team2.equals(rating.getTeam())) {
                raiting2 += rating.getRating();
            }
        }

//        int raiting1 = 0;
//        int raiting2 = 0;
//        for (Player aComm1 : comm1) {
//            raiting1 += aComm1.getRating();
//        }
//        for (Player aComm2 : comm2) {
//            raiting2 += aComm2.getRating();
//        }
        if (raiting1 > raiting2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Победила команда: " + team1 + " со счетом: " + raiting1 + ":" + raiting2);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else if (raiting1 < raiting2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Победила команда: " + team2 + " со счетом: " + raiting2 + ":" + raiting1);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Ничья! Рейтинг у команд, одинаковый!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        //        String result = (raiting1 > raiting2) ? "Победила команда: \"A\" со счетом: " + raiting1 + ":" + raiting2 :
//                "Победила команда: \"B\" со счетом: " + raiting2 + ":" + raiting1;
//        System.out.println(result);
    }


    public void aLotOfTeamsWithPlayers() {
        Set<String> teamList = new HashSet<>();
        Set<Player> playerSet = new HashSet<>(playerList);
        for (Player team : playerSet) {
            teamList.add(team.getTeam());
        }
        for (String team : teamList) {
            System.out.println("Команда: " + team);
            for (Player player : playerSet) {
                if (team.equals(player.getTeam())) {
                    System.out.println("Имя: " + player.getName() + " Возраст: " + player.getAge() + " Рейтинг: " + player.getRating());
                }
            }
        }
    }

    /**
     * The method in which players are sorted into teams
     */
    public void sortingPlayersIntoTeams() {
        Set<String> teams = new TreeSet<>();
        for (Player p : playerList) {
            teams.add(p.getTeam());
        }
        Map<String, ArrayList<Player>> teamsMap = new HashMap<>();
        for (String team : teams) {
            ArrayList<Player> players = new ArrayList<>();
            for (Player p : playerList) {
                if (p.getTeam().equals(team)) {
                    players.add(p);
                }
            }
            teamsMap.put(team, players);
        }
        for (Map.Entry<String, ArrayList<Player>> entry : teamsMap.entrySet()) {
            System.out.println("Команда: " + entry.getKey());
            for (Player p : entry.getValue()){
                System.out.println("Имя: " + p.getName() + " Возраст: " + p.getAge() + " Рейтинг: " + p.getRating());
            }
        }
    }

    /**
     * Farewell method
     */
    public void finishProgramm() {
        System.out.println("Досвидания!");
    }

}