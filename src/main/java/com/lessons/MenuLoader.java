package src.main.java.com.lessons;

public enum MenuLoader {
    Q("q", "quit"),
    F("f", "download images from file"),
    C("c", "download image for console"),
    A("a", "about");
    private String consoleMenu;
    private String description;

    public String getConsoleMenu() {
        return consoleMenu;
    }

    public String getDescription() {
        return description;
    }

    MenuLoader(String consoleMenu, String description) {
        this.consoleMenu = consoleMenu;
        this.description = description;
    }

    public MenuLoader getMenuCommand(String menuCommand){
        for (MenuLoader menu : MenuLoader.values()){
            if (menuCommand.equals(menu.getConsoleMenu())) {
                return menu;
            }
        }
        return A;
    }

    public void printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (MenuLoader m : MenuLoader.values()){
            stringBuilder.append("Please press ");
            stringBuilder.append(m.consoleMenu);
            stringBuilder.append(" - ");
            stringBuilder.append(m.description);
            System.out.println(stringBuilder.toString());
            stringBuilder.delete(0, 100);
        }
    }
}
