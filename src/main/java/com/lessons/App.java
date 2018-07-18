package src.main.java.com.lessons;

import src.main.java.com.lessons.People;
import src.main.java.com.lessons.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        List<People> it = new ArrayList<>();
        it.add((new People(1l, 23, "Vasia", Role.DEVELOPER)));
        it.add((new People(2l, 18, "Marina", Role.DEVELOPER)));
        it.add((new People(3l, 19, "Petro", Role.TESTER)));
        it.add((new People(4l, 17, "Anna", Role.DEVELOPER)));
        it.add((new People(5l, 21, "Sergey", Role.TESTER)));

        it.stream().filter((p) -> p.getAge() > 20).filter((r) -> r.getRole() == Role.DEVELOPER).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        it.stream().limit(1).forEach(System.out::println);
        it.stream().skip(it.size() - 1).forEach(System.out::println);
        System.out.println("---------------------------------------------------");
        String str = it
                .stream()
                .filter((v) -> v.getAge() <= 18)
                .map((m) -> m.getName()).collect(Collectors.joining(" "));

        System.out.println(str);
        System.out.println("---------------------------------------------------");
        Long col = it.stream().filter((a) -> a.getAge() > 20).count();
        int sum = it.stream().filter((a) -> a.getAge() > 20).mapToInt(People::getAge).reduce((s1,s2)->s1+s2).getAsInt();
        System.out.println("кол-во: " + col+" сумма: "+sum+" среднее: "+sum/col);

    }
}
