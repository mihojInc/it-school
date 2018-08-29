package src.main.java.com.lessons;

public enum MenuATM {
    EMPTY("CREDIT AGRICOLE BANK select a transaction:", 0),
    BALANCE("1.Balance Enquiry", 1),
    WITHDRAW_MONEY("2.WithDraw Money", 2),
    CHANGE_PIN("3.Change PIN", 3),
    PRINT_HISTORY("4.Print history", 4),
    QUIT("5.Quit", 5);

    private String descriptionMenu;
    private int num;
    private String name;

    private MenuATM(String descriptionMenu, int num) {
        this.descriptionMenu = descriptionMenu;
        this.num = num;
    }

    public String getDescriptionMenu() {
        return descriptionMenu;
    }

    public int getNum() {
        return num;
    }
    public MenuATM getName(int i) {
        MenuATM v = MenuATM.EMPTY;
        MenuATM[] arr = MenuATM.values();
        for (MenuATM k : arr) {
            if (i == k.getNum()) {
                name = k.name();
                v = k;
            }
        }
        return v;
    }
}
