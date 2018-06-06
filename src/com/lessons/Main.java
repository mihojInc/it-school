package com.lessons;

public class Main {

    public static void main(String[] args) {
        //loop for out season and month is this season
        for(Season s : Season.values()) {
            System.out.println(s.getRus());

            for (Month m : Month.values()) {
                if(s.getRus()==m.getSeason())
                {
                    System.out.println("\t Месяц " + m.getRusName() + " Количество дней " + m.getColDay());
                }
            }
        }
    }
}
