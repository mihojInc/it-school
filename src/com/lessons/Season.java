package com.lessons;
/**
 * This enup describe season
 * Parametr is a name of season in russian
 */
public enum  Season {
    WINTER("Зима"),
    SPRING ("Весна"),
    SUMMER("Лето"),
    OUTUM("Осень");

    private String rus;

    Season(String rus) {
        this.rus = rus;
    }

    public void setRus(String rus) {
        this.rus = rus;
    }
    public String getRus() {
        return rus;
    }
}
