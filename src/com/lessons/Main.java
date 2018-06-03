package com.lessons;

public class Main {
    /**
     * Method describes correspondence of months to seasons and number of days in each month.
     * @param args massive of data
     */

    public static void main(String[] args) {
        for (Seasons calendar : Seasons.values()) {
            System.out.println("Сезон: " + calendar.getRuName());
            for (Month month : calendar.getMonths()) {
                System.out.println("   Месяц:  " + month.getRuMonth() + " Кол-во дней: " + month.getDays());
            }
        }
    }
}