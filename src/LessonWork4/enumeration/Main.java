package LessonWork4.enumeration;

public class Main {
    public static void main(String[] args) {

        for (Sezon sezon : Sezon.values()){
            System.out.println("Имя сезона:" + sezon.getNameSezon());
            for (Calendar calendar : sezon.getCalendar()){
                System.out.println("Имя месяца: "+ calendar.getRuName() +
                " Количество дней: " + calendar.getKolDay());
            }
        }
    }
}
