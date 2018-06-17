package p06_Football_Team_Generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name == null || name.equals(" ")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    private boolean isPlayerInTheTeam(String name){
        for (Player player : this.getPlayers()) {
            if(player.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void removePlayer(String name) {
        if(isPlayerInTheTeam(name)){
            this.players.removeIf(player -> player.getName().equals(name));
        }else{
            throw new IllegalArgumentException("Player "+name+" is not in "+this.getName()+" team.");
        }

    }

    public Double getTeamRatings(){
        if(this.getPlayers().isEmpty()){
            return 0.0;
        }
        return this.getPlayers().stream().mapToDouble(Player::getSkills).average().getAsDouble();
    }
}
