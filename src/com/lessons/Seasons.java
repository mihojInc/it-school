package com.lessons;

/**
 * This is enum class that contains seasons and their months.
 */
public enum Seasons {

        WINTER("Зима", new Month[]{Month.DECEMBER, Month.JANUARY, Month.FEBRUARY}),
        SPRING("Весна", new Month[]{Month.MARCH, Month.APRIL, Month.MAY}),
        SUMMER("Лето", new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}),
        AUTUMN("Осень", new Month[]{Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER});

        private String ruName;
        private Month[] months;

        Seasons(String ruName, Month[] months){
            this.ruName = ruName;
            this.months = months;
        }

    /**
     * This method describes russian name for season.
     * @return String
     */
        public String getRuName() {
            return ruName;
        }
    /**
     * This method describes list of month for each season.
     * @return massive
     */
        public Month[] getMonths() {
            return months;
        }
    }

