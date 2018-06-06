package com.lessons;

public enum Season {
    SPRING("Весна", new Month[]{Month.APRIL, Month.MARCH, Month.MAY}),
    SUMMER("Лето", new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}),
    AUTUMN("Осень", new Month[]{Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER}),
    WINTER("Зима", new Month[]{Month.DECEMBER, Month.JUNUARY, Month.FEBRUARY});

    private String nameSeason;
    private Month[] month;

    Season(String nameSeason, Month[] month) {
        this.nameSeason = nameSeason;
        this.month = month;
    }

    public String getNameSeason() {
        return nameSeason;
    }

    public Month[] getMonth() {
        return month;
    }
}
