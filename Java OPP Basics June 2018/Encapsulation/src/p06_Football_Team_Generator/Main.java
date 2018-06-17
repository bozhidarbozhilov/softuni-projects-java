package p06_Football_Team_Generator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputData = scanner.nextLine();
        List<Team> teams = new ArrayList<>();

        while (!"END".equals(inputData)) {
            String[] tokens = inputData.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            switch (command) {
                case "Team":
                    addTeam(teams, teamName);
                    break;
                case "Add":
                    if(isTeamExist(teams,teamName)){
                        try{
                            addPlayerToTeam(teams, tokens);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }

                    } else{
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }
                    break;
                case "Remove":
                    if(isTeamExist(teams, teamName)){
                        try{
                            removePlayer(teams, tokens[2], teamName);
                        }catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                    }else{
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }


                    break;
                case "Rating":
                    if (isTeamExist(teams, teamName)){
                        Team teamRating =  teams.stream()
                                .filter(team -> team.getName().equals(teamName))
                                .findAny().get();
                        Double rating = teamRating.getTeamRatings();
                        System.out.printf("%s - %d%n", teamName, Math.round(rating));
                    }else{
                        System.out.println("Team " + teamName + " does not exist.");
                        break;
                    }
                    break;
                default:
                    break;
            }

            inputData = scanner.nextLine();
        }
    }

    private static void removePlayer(List<Team> teams, String playerName, String teamName) {
        Team teamToRemove =  teams.stream().filter(team -> team.getName().equals(teamName)).findAny().get();
        teamToRemove.removePlayer(playerName);
    }

    private static void addPlayerToTeam(List<Team> teams, String[] tokens) {
        String teamName = tokens[1];
        String playerName = tokens[2];
        int endurance = Integer.parseInt(tokens[3]);
        int sprint = Integer.parseInt(tokens[4]);
        int dribble = Integer.parseInt(tokens[5]);
        int passing = Integer.parseInt(tokens[6]);
        int shooting = Integer.parseInt(tokens[7]);

        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
        Team teamToAdd =  teams.stream().filter(team -> team.getName().equals(teamName)).findAny().get();
        teamToAdd.addPlayer(player);
    }

    private static void addTeam(List<Team> teams, String name) {
        Team team = new Team(name);
        teams.add(team);
    }

    private static boolean isTeamExist(List<Team> teams, String name) {
        for (Team team : teams) {
            if(team.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
