package com.lessons;

import java.util.*;

public class PlayerManager {
    private Map<String, ArrayList<Player>> arrayListMap = new HashMap<>();

    /**
     * The method in which players are created, and added to the collection Map
     * @param scanner
     */
    public void addPlayers(Scanner scanner) throws NullPointerException {
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
            if (!arrayListMap.containsKey(team)) {
                arrayListMap.put(team, new ArrayList<>());
                arrayListMap.get(team).add(new Player(name, age, rating));
            } else {
                arrayListMap.get(team).add(new Player(name, age, rating));
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Игроки были успешно созданы!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * The method in which players are sorted by rating
     */
    public void showPlayersByRating() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Список футболистов по рейтингу");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //Сортировка игроков по рейтингу через Comparator
        Set<Player> players = new TreeSet<>(Comparator.comparing(Player::getRating));
        for (ArrayList<Player> p : arrayListMap.values()) {
            players.addAll(p);
        }
        for (Player player : players) {
            System.out.println("Имя игрока: " + "-" + player.getName() + "-" + " Рейтинг игрока: " + "-" + player.getRating() + "-");
        }
    }

    /**
     * Unique players method
     */
    public void showUniquePlayers() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Список уникальных игроков!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Map.Entry<String, ArrayList<Player>> entry : arrayListMap.entrySet()) {
            for (Player player : entry.getValue()) {
                System.out.println("Имя игрока: " + "-" + player.getName() + "-" + " Возраст: " + "-" + player.getAge()
                        + "-" + " Рейтинг по FIFA: " + "-" + player.getRating() + "-");
            }
        }
    }

    /**
     * The method in which the player is removed by name
     */
    public void removePlayers(Scanner scanner) {
        System.out.print("Напишите имя игрока которого хотите удалить: ");
        System.out.println(" ");
        String name = scanner.next();
        for (Map.Entry<String, ArrayList<Player>> entry : arrayListMap.entrySet()) {
            ArrayList<Player> list = entry.getValue();
            for (Player player : list) {
                if(player.getName().equals(name)) {
                    list.remove(player);
                }
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Игроки которые остались после удаления.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Map.Entry<String, ArrayList<Player>> entry : arrayListMap.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * The method in which teams play their match
     * @param
     * @param
     */
    public void playMatch(Scanner scanner) {
        String team1, team2;
        int rating1 = 0, rating2 = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя первой команды!");
        team1 = scan.next();
        System.out.println("Введите имя второй команды!");
        team2 = scan.next();

        for (Map.Entry<String, ArrayList<Player>> playerEntry : arrayListMap.entrySet()) {
            if (team1.equals(playerEntry.getKey())) {
                for (Player player : playerEntry.getValue()) {
                    rating1 += player.getRating();
                }
            }
            if (team2.equals(playerEntry.getKey())) {
                for (Player player : playerEntry.getValue()) {
                    rating2 += player.getRating();
                }
            }
        }
        if (rating1 > rating2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Победила команда: " + team1 + " со счетом: " + rating1 + ":" + rating2);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else if (rating1 < rating2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Победила команда: " + team2 + " со счетом: " + rating2 + ":" + rating1);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Ничья! Рейтинг у команд, одинаковый!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }

    }

    /**
     * Method of distribution of players by commands
     */
    public void sortingPlayersIntoTeams() {
        for (Map.Entry<String, ArrayList<Player>> entry : arrayListMap.entrySet()) {
            System.out.println("Команда: " + entry.getKey());
            for (Player p : entry.getValue()) {
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
