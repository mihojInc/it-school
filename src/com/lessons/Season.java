package com.lessons;


public enum Season {
    WINTER ("зима", new Month[]{Month.DECEMBER, Month.JANUARY, Month.FEBRUARY}),
    SPRING ("весна", new Month[]{Month.MARCH, Month.APRIL, Month.MAY}),
    SUMMER ("лето", new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}),
    AUTUMN ("осень",new Month[]{Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER});


    private String ruName;
    private Month[] month = new Month[3];

    Season(String ruName, Month[] month){
        this.ruName = ruName;
        this.month = month;
    }

    public String getRuName(){
        return ruName;
    }

    public Month[] getMonth(){
        return month;
    }
}
