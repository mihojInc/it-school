package com.lessons;

public enum Month {
    /**
     * list of months
     */
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

    /**
     * var ruName set name of month in russian;
     * var days set quantity of days in each month;
     */
    private String ruName;
    private int days;

    /**
     * constructor sets russian name and quantity of days for each month
     * @param ruName
     * @param days
     */
    Month(String ruName, int days){
        this.ruName = ruName;
        this.days = days;
    }

    /**
     * method gets russian name
     * @return
     */
    public String getRuName() {
        return ruName;
    }

    /**
     * method gets quantity of days
     * @return
     */
    public int getDays() {
        return days;
    }
}
