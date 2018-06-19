import java.util.Date;

public class Player {
    /**
     * Namr of player
     */
    private String name;
    /**
     * date birth player
     */
    private String dateBirth;
    /**
     * rank of players
     */
    private int rank;
    /**
     * team where the players play
     */
    private Team team;
    /**
     * cost player
     */
    private double cost;

    public Player(String name, String dateBirth, int rank, Team team, double cost) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.rank = rank;
        this.team = team;
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + dateBirth.hashCode() + rank + team.hashCode() + (int)cost;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (!name.equals(other.name))
            return false;
        if (!dateBirth.equals(other.dateBirth))
            return false;
        if (rank != other.rank)
            return false;
        if (!team.equals(other.team))
            return false;
        if (cost != other.cost)
            return false;
        return true;


    }
}
