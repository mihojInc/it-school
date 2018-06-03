package LessonWork4.enumeration;

public enum Sezon {

    ZIMA("Зима", new Calendar[]{ Calendar.DECEMBE, Calendar.NONEMBER,Calendar.JANUARY}),
    VECNA("Весна", new Calendar[]{Calendar.MAY, Calendar.MARCH,Calendar.APRIL}),
    LETO("Лето",new Calendar[]{Calendar.JULI,Calendar.JUNE,Calendar.AUGUST}),
    OCEN("Осень",new Calendar[]{Calendar.SEPTEMBER, Calendar.OCTOBER,Calendar.NONEMBER});

    private String nameSezon;
    private Calendar[] calendar;
    Sezon(String nameSezon, Calendar[] calendar){
        this.nameSezon = nameSezon;
        this.calendar = calendar;
    }

    public String getNameSezon() {
        return nameSezon;
    }

    public Calendar[] getCalendar() {
        return calendar;
    }
}
