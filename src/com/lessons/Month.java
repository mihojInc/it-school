package com.lessons;

/**
 * This enum class describes all months and number of days in each.
 */
public enum Month {

    JANUARY("Январь", 31),
    FEBRUARY("Февраль", 28),
    MARCH("Март", 31),
    APRIL("Апрель", 30),
    MAY("Май", 31),
    JUNE("Июнь", 31),
    JULY("Июль", 30),
    AUGUST("Август", 31),
    SEPTEMBER("Сентярь", 30),
    OCTOBER("Октябрь", 31),
    NOVEMBER("Ноябрь", 30),
    DECEMBER("Декабрь", 31);

    private String ruMonth;
    private int days;

    Month(String ruMonth, int days) {
        this.ruMonth = ruMonth;
        this.days = days;
    }

    /**
     * Method describes russian name for each month.
     * @return String
     */
    public String getRuMonth() {
        return this.ruMonth;
    }

    /**
     * Method describes number of days in each month.
     * @return int
     */
    public int getDays() {
        return this.days;
    }
}

