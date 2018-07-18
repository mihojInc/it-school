package com.lessons;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Person> peoples = Arrays.asList(
                new Person("Kolya", Role.DEV, 17),
                new Person("Rita", Role.DEV, 21),
                new Person("Oleg", Role.DEV, 19),
                new Person("Jenja", Role.DEV, 25),
                new Person("Galya", Role.TEST, 13),
                new Person("Kolya", Role.TEST, 16),
                new Person("Igor", Role.DEV, 30),
                new Person("Ira", Role.DEV, 26),
                new Person("Mitja", Role.DEV, 28),
                new Person("Sveta", Role.TEST, 15),
                new Person("Goga", Role.DEV, 18));

        System.out.println("---------Start data---------------");

        peoples.stream().forEach(person -> System.out.println(person.toString()));

        System.out.println("---------All developers > 20 years old---------------");

        List twentyYearsOld = Arrays.asList(peoples.stream()
                .filter(person -> person.getAge() > 20 & person.getRole() == Role.DEV)
                .toArray());
        twentyYearsOld.forEach(System.out::println);

        double averageAge = twentyYearsOld.stream()
                .mapToInt(a -> ((Person) a).getAge())
                .average()
                .getAsDouble();

        System.out.println("His average age: " + averageAge);
        System.out.println("-------get first two person in developer > 20 years---");

        twentyYearsOld.stream()
                .limit(2)
                .forEach(System.out::println);

        System.out.println("-------and last two-----------------------------------");

        twentyYearsOld.stream()
                .skip(twentyYearsOld.size() - 2)
                .forEach(System.out::println);

        System.out.println("-------String of name testers < 18 years--------------");

        String testersName = peoples.stream()
                .filter(person -> person.getAge() < 18 && person.getRole() == Role.TEST)
                .map(a -> a.getName() + " - " + a.getAge() + " year")
                .reduce((person, person2) -> person + ", " + person2)
                .get();

        System.out.println(testersName);

    }

}
