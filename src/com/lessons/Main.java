package com.lessons;

public class Main {

    public static void main(String[] args){

        for (Season season: Season.values()){
            System.out.println("Сезон: " + season.getRuName());
            for (Month month: season.getMonth()){
                System.out.println("    Месяц: " + month.getRuName() + ", " + month.getDays());
            }
        }

    }
}
