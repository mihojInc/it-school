package com.lessons;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamHelper {
    private List<People> peopleList = new ArrayList<>();

    /**
     * List of programmers and testers
     */
    public void listPeople() {
        peopleList.add(new People(2, 35, "Иван", Role.DEVELOPER));
        peopleList.add(new People(3, 16, "Алина", Role.TESTER));
        peopleList.add(new People(5, 33, "Юра", Role.DEVELOPER));
        peopleList.add(new People(4, 20, "Антон", Role.TESTER));
        peopleList.add(new People(6, 22, "Настя", Role.TESTER));
        peopleList.add(new People(7, 18, "Коля", Role.DEVELOPER));
        peopleList.add(new People(8, 19, "Миша", Role.DEVELOPER));
        peopleList.add(new People(9, 28, "Алексей", Role.DEVELOPER));

        for (People people : peopleList) {
            System.out.println(people);
        }
        System.out.println(" ");
    }

    /**
     * List of only Java developers whose age is over 20
     */
    public void guruDevelopmentInJava() {
        String string = peopleList
                .stream()
                .filter(people -> people.getAge() > 20 && people.getRole() == Role.DEVELOPER)
                .map((people) -> people.getName())
                .collect(Collectors.joining(", "));
        System.out.println("Список топовых Java разработчиков: " + string);
        System.out.println(" ");
    }

    /**
     * Average age of guys over 20 years old
     */
    public void averageAge() {
        Double averageAge = peopleList
                .stream()
                .filter(people -> people.getAge() >= 20 && people.getRole() == Role.DEVELOPER)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
        System.out.println("Средний возраст парней: " + averageAge);
        System.out.println(" ");
    }

    /**
     * First and last user in the list
     */
    public void theFirstAndLastDeveloper() {
        List<People> list = peopleList
                .stream().filter(people -> people.getId() < 5)
                .limit(1)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println(" ");

        peopleList
                .stream()
                .skip(peopleList.size() - 1)
                .forEach(System.out::println);
    }
}
