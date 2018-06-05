package com.lessons;

public enum Month {
    JANUARY ("январь", 31),
    FEBRUARY ("февраль", 28),
    MARCH ("март", 31),
    APRIL ("апрель", 30),
    MAY ("май", 31),
    JUNE ("июнь", 30),
    JULY ("июль", 31),
    AUGUST ("август", 31),
    SEPTEMBER ("сентябрь", 30),
    OCTOBER ("октябрь", 31),
    NOVEMBER ("ноябрь", 30),
    DECEMBER ("декабрь", 31);

    private String ruName;
    private int days;

    Month(String ruName, int days){
        this.ruName = ruName;
        this.days = days;
    }

    public String getRuName() {
        return ruName;
    }

    public int getDays() {
        return days;
    }
}
