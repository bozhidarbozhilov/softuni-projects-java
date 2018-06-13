package p06_Raw_Data;

public class Cargo {
    private String type;
    private int weight;

    public Cargo(String type, int weight){
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }
}
