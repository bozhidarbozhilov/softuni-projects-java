package p04_Shopping_Spree;

public class Product {
    private String name;
    private Double cost;

    public Product(String name, Double cost){
        this.setName(name);
        this.setCost(cost);
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.equals(" ")|| name.isEmpty() || name == null){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        if(cost<0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }
}
