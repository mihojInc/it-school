package com.lessons;

/**
 * class enum season
 */
public enum Season {
    WINTER("зима", new Month[]{Month.DECEMBER, Month.JANUARY, Month.FEBRUARY}),
    SPRING("весна", new Month[]{Month.MARCH, Month.APRIL, Month.MAY}),
    SUMMER("лето", new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}),
    AUTUMN("осень", new Month[]{Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER});

    /**
     * ru name of season
     */
    private final String ruNameSeason;
    /**
     * month of season
     */
    private Month[] monthsOfSeason;

    Season(String ruNameSeason, Month[] months) {
        this.ruNameSeason = ruNameSeason;
        this.monthsOfSeason = months;
    }

    /*
     * method  get ru name of season
     * @return ruNameSeason
     */
    public String getRuNameSeason() {
        return ruNameSeason;
    }

    /**
     * method get month of season
     * @return monthsOfSeason
     */
    public Month[] getMonthsOfSeason() {
        return monthsOfSeason;
    }
}
