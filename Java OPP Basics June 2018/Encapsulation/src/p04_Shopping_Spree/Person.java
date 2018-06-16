package p04_Shopping_Spree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private Double money;
    private List<Product> bag;

    public Person(String name, Double money) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.equals(" ") || name == null) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    private void setMoney(Double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void addProduct(Product product) {
        this.bag.add(product);
    }

    public List<Product> getBag() {
        return Collections.unmodifiableList(this.bag);
    }

    public boolean canAfford(Product product) {
        return this.getMoney() >= product.getCost();
    }
    public void decreaseMoney(Double cost){
        this.money -= cost;
    }


    @Override
    public String toString() {
        if(!this.getBag().isEmpty()){
            return this.getName() + " - "
                    +this.getBag().stream().map(Product::getName).collect(Collectors.joining(", "));
        }else{
            return this.getName() + " - Nothing bought";
        }

    }
}
