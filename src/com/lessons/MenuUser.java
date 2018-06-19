package src.com.lessons;

public enum MenuUser {
    EMPTY("Работа с массивом:",0),
    ADD_ELEMENT("1.Ввести число",1),
    SORT_MAX("2.Сортировка по убыванию",2),
    SORT_MIN("3.Сортировка по возрастанию",3),
    CLEAN_ARRAY("4.Очистка массива",4),
    QUIT("5.Выход",5);

    private String description;
    private int num;
    public String name;
    private MenuUser(String description, int num) {
        this.description = description;
        this.num = num;
    }

    public String getDescription() {
        return description;
    }

    public int getNum(){
        return num;
    }
    public String getName(int i){
        MenuUser[] arr = MenuUser.values();
        for (MenuUser k : arr) {
            if (i == k.getNum()){
                name = k.name();
            }
            //System.out.println(m.getDescription());
        }
        return name;
    }
}
