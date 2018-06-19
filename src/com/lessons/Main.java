package src.com.lessons;

public class Main {

    public static void main(String[] args) {


        MenuUser[] menu = MenuUser.values();
        for (MenuUser m : menu) {
            System.out.println(m.getDescription());
        }
        System.out.print("Сделайте свой выбор:");
        MenuUser p = MenuUser.EMPTY;
        ManageArray item = new ManageArray();
        int i = 4;
        System.out.println(p.getName(i));


        switch (p) {
            case ADD_ELEMENT:
                item.addElement();
                break;
            case SORT_MAX:
                item.sortMax();
                break;

        }


    }
}
