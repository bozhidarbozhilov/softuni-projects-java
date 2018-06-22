package p04_Mordors_Cruelty_Plan;

public class Food {
    private String name;

    public Food(String name){
        this.setName(name);
    }
    private void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
