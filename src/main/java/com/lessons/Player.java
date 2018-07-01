package main.java.com.lessons;

/**
 * Football player
 */
public class Player {

    private String name;
    private byte age = 18;
    private String team = "Street";
    private int rang = 10;

    public Player() {
    }

    public Player(String name, byte age, String team, int rang) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.rang = rang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    /**
     * @return true only if all fields equals
     */
    @Override
    public boolean equals(Object o) {

        if (o instanceof Player) {
            Player player = (Player) o;
            if (player.getName().equals(this.getName()) && player.getAge() == this.getAge()
                    && player.getRang() == this.getRang()) {

                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age + rang;
    }
}
