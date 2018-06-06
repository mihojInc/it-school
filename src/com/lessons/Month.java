package com.lessons;

public enum Month {
    JUNUARY("Январь", 30),
    FEBRUARY("Февраль", 31),
    MARCH("Март", 30),
    APRIL("Апрель", 31),
    MAY("Май", 30),
    JUNE("Июнь", 31),
    JULY("Июль", 30),
    AUGUST("Август", 31),
    SEPTEMBER("Сентябрь", 30),
    OCTOBER("Октябрь", 31),
    NOVEMBER("Ноябрь", 30),
    DECEMBER("Декабрь", 31);

    private String nameMonth;
    private int dayNumber;

    Month(String nameMonth, int dayNumber) {
        this.nameMonth = nameMonth;
        this.dayNumber = dayNumber;
    }

    public String getNameMonth() {
        return nameMonth;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
