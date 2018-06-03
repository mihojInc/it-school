package LessonWork4.enumeration;

public enum Calendar {

    JANUARY("Январь", 31),
    FEBRUARY("Февраль", 30),
    MARCH("Март", 28),
    APRIL("Апрель", 29),
    MAY("Май",30),
    JUNE("Июнь", 31),
    JULI("Июль", 30),
    AUGUST("Август", 31),
    SEPTEMBER("Сентябрь", 30),
    OCTOBER("Октябрь", 31),
    NONEMBER("Ноябрь" ,30 ),
    DECEMBE("Декабрь" , 31);

    private String ruName;

    private int kolDay;

    Calendar (String ruName, int kolDay){
        this.ruName=ruName;
        this.kolDay=kolDay;
    }

    public String getRuName() {
        return ruName;
    }

    public int getKolDay() {
        return kolDay;
    }
}
