import java.util.HashSet;
import java.util.Objects;

public class Team {
    /**
     * name team
     */
    private String nameTeam;
    /**
     * available money for bue the players
     */
    private double curMoney = 0.0d;

    /**
     * list of players in the team
     */
    private HashSet<Player> players;
    /**
     * Country wherw located the team
     */
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Double.compare(team.curMoney, curMoney) == 0 &&
                Objects.equals(nameTeam, team.nameTeam) &&
                Objects.equals(players, team.players) &&
                Objects.equals(country, team.country);
    }

    @Override
    public int hashCode() {

        return nameTeam.hashCode() + (int)curMoney  + players.hashCode() + country.hashCode();
    }
}
