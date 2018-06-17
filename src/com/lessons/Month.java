package com.lessons;

/**
 * enum class month
 */
public enum Month {
    JANUARY("январь",31),
    FEBRUARY("февраль",28),
    MARCH("март",30),
    APRIL("апрель",31),
    MAY("май",31),
    JUNE("июнь",30),
    JULY("июль",31),
    AUGUST("август",30),
    SEPTEMBER("сентябрь",31),
    OCTOBER("октябрь",30),
    NOVEMBER("ноябрь",31),
    DECEMBER("декабрь",31);

    /**
     * russian name of month
     */
    private String ruNameMonth;
    /**
     * days of month
     */
    private int days;

    Month(String ruNameMonth, int days){
        this.ruNameMonth = ruNameMonth;
        this.days = days;
    }

    /**
     * method get days of month
     * @return days
     */
    public int getDays() {
        return days;
    }

    /**
     * method get russian name of month
     * @return ruNameMonth
     */
    public String getRuNameMonth() {
        return ruNameMonth;
    }
}
