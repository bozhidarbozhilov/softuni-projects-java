import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class p04_FootballStats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TeamStats> teamStats = new ArrayList<>();

        String match = scanner.nextLine();
        while(!"Season End".equals(match)){
            String[] tokens = match.split("[\\s:\\-]+");
            String homeTeam = tokens[0];
            String guestTeam = tokens[1];
            int homeGoals = Integer.parseInt(tokens[3]);
            int guestGoals = Integer.parseInt(tokens[4]);

            TeamStats currentMatch = new TeamStats(homeTeam, guestTeam, homeGoals, guestGoals);
            TeamStats reverseMatch = new TeamStats(guestTeam, homeTeam, guestGoals, homeGoals);
            teamStats.add(currentMatch);
            teamStats.add(reverseMatch);

            match = scanner.nextLine();
        }

        String[] teamsToPrint = scanner.nextLine().split(", ");

        for (String team : teamsToPrint) {
            teamStats.stream().filter(t->t.team.equals(team))
                    .sorted(Comparator.comparing(TeamStats::getOpponentTeam))
                    .forEach(m->
                    System.out.print(m.toString()));
        }

    }
}
class TeamStats{
    String team;
    String opponentTeam;
    int teamGoals;
    int opponentGoals;

    public TeamStats(String team, String opponentTeam, int teamGoals, int opponentGoals) {
        this.team = team;
        this.opponentTeam = opponentTeam;
        this.teamGoals = teamGoals;
        this.opponentGoals = opponentGoals;
    }

    public String getTeam() {
        return team;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public int getTeamGoals() {
        return teamGoals;
    }

    public int getOpponentGoals() {
        return opponentGoals;
    }

    @Override
    public String toString() {
        return String.format("%s - %s -> %d:%d%n", team, opponentTeam, teamGoals, opponentGoals);
    }
}
