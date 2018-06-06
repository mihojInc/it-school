package com.lessons;

public enum  Month {
    January (31, "Январь", Season.WINTER.getRus()),
    February (30, "Февраль", Season.WINTER.getRus()),
    March (31, "Март", Season.SPRING.getRus()),
    April (30, "Апрель", Season.SPRING.getRus()),
    May (31, "Май", Season.SPRING.getRus()),
    June (30, "Июнь", Season.SUMMER.getRus()),
    July (31, "Июль", Season.SUMMER.getRus()),
    August (31, "Август", Season.SUMMER.getRus()),
    September (30, "Сентябрь", Season.OUTUM.getRus()),
    October (31, "Октябрь", Season.OUTUM.getRus()),
    November (30, "Ноябрь", Season.OUTUM.getRus()),
    December (31, "Декабрь", Season.WINTER.getRus());

    private int colDay;
    private String rusName, season;

    public int getColDay() {
        return colDay;
    }

    public void setColDay(int colDay) {
        this.colDay = colDay;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getRusName() {
        return rusName;
    }

    public void setRusName(String rusName) {
        this.rusName = rusName;
    }

    Month(int colDay, String rusName, String season) {
        this.colDay = colDay;
        this.rusName = rusName;
        this.season = season;
    }
}
