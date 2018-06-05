package com.lessons;


public enum Season {
    /**
     * list of seasons
     */
    WINTER ("зима", new Month[]{Month.DECEMBER, Month.JANUARY, Month.FEBRUARY}),
    SPRING ("весна", new Month[]{Month.MARCH, Month.APRIL, Month.MAY}),
    SUMMER ("лето", new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}),
    AUTUMN ("осень",new Month[]{Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER});

    /**
     * var ruName set name of season in russian;
     * var month set list of months for each season
     */
    private String ruName;
    private Month[] month = new Month[3];

    /**
     * constructor sets russian name and list of months for each season
     * @param ruName
     * @param month
     */
    Season(String ruName, Month[] month){
        this.ruName = ruName;
        this.month = month;
    }

    /**
     * method gets russian name
     * @return
     */
    public String getRuName(){
        return ruName;
    }

    /**
     * method gets list of months
     * @return
     */
    public Month[] getMonth(){
        return month;
    }
}
