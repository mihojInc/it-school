package com.lessons;

import java.util.*;

public class PlayerManager {
    private List<Player> playerList = new ArrayList<>();
    //Две команды игроков
    private List<Player> commandOne = new ArrayList<>();
    private List<Player> commandTwo = new ArrayList<>();

    //Constructor
    public List<Player> getPlayerList() {
        return playerList;
    }

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
        String name;
        int age, rating;
        while (true) {
            System.out.println("Сoздайте игрока! Для выхода нажмите \"q\"");
            System.out.print("Введите имя игрока: ");
            name = scanner.next();
            if (name.equals("q")) break;
            System.out.print("Введите возраст игрока: ");
            while (!scanner.hasNextInt()){
                System.out.print("Введите возраст игрока цифрами: ");
                scanner.next();
            }
            age = scanner.nextInt();
            System.out.print("Введите рейтинг игрока по FIFA: ");
            while (!scanner.hasNextInt()){
                System.out.print("Введите рейтинг игрока цифрами: ");
                scanner.next();
            }
            rating = scanner.nextInt();
            playerList.add(new Player(name, age, rating));
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
                if (p1.getRating() == p2.getRating()) return 0;
                else if (p1.getRating() > p2.getRating()) return 1;
                else return -1;
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
                    + " Рейтинг по FIFA: " + player.getRating());
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
     * The method of comparing the two teams by rating
     * @param comm1
     * @param comm2
     */
    public void playMatch(List<Player> comm1, List<Player> comm2) {
        int raiting1 = 0;
        int raiting2 = 0;
        for (Player aComm1 : comm1) {
            raiting1 += aComm1.getRating();
        }
        for (Player aComm2 : comm2) {
            raiting2 += aComm2.getRating();
        }
        if (raiting1 > raiting2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Победила команда \"A\" со счетом: " + raiting1 + ":" + raiting2);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } else if (raiting1 < raiting2) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Победила команда \"B\" со счетом: " + raiting2 + ":" + raiting1);
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

    /**
     * Farewell method
     */
    public void finishProgramm() {
        System.out.println("Досвидания!");
    }

}