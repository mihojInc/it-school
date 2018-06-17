package com.lessons;

/**
 * class to run
 */
public class Runner {
    public static void main(String[] args) {
        for (Season season : Season.values()) {
            System.out.println(season.getRuNameSeason() + ":");
            for (Month month : season.getMonthsOfSeason()) {
                System.out.println(month.getRuNameMonth() + " " + month.getDays());
            }
            System.out.println();
        }
    }
}
