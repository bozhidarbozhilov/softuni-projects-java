package p06_Football_Team_Generator;

public class Player {
    private String name;
    private Integer endurance;
    private Integer sprint;
    private Integer dribble;
    private Integer passing;
    private Integer shooting;

    public Player(String name, Integer endurance, Integer sprint, Integer dribble, Integer passing, Integer shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name ==null || name.equals(" ")){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private Integer getEndurance() {
        return this.endurance;
    }

    private void setEndurance(Integer endurance) {
        if(endurance<0 || endurance>100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private Integer getSprint() {
        return this.sprint;
    }

    private void setSprint(Integer sprint) {
        if(sprint<0 || sprint>100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private Integer getDribble() {
        return this.dribble;
    }

    private void setDribble(Integer dribble) {
        if(dribble<0 || dribble>100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private Integer getPassing() {
        return this.passing;
    }

    private void setPassing(Integer passing) {
        if(passing <0 || passing>100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private Integer getShooting() {
        return this.shooting;
    }

    private void setShooting(Integer shooting) {
        if(shooting<0 || shooting>100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public Double getSkills(){
        return (this.getDribble() + this.getEndurance()
                + this.getPassing() + this.getShooting()+this.getSprint())/5.0;
    }
}
