package p05_Pizza_Calories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private String name;
    private int numberOfToppings;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if(name.length()<1||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public int getNumberOfToppings() {
        return this.numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        if(numberOfToppings<0 || numberOfToppings>10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public Dough getDough() {
        return this.dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(this.toppings);
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }


    Double calcTotalCalories(){
        Double totalCalories =this.getToppings().stream().mapToDouble(Topping::calcToppingCalories).sum();
/*        for (Topping topping : toppings) {
            totalCalories += topping.calcToppingCalories();
        }*/
        totalCalories += this.dough.calcDoughCalories();
        return totalCalories;
    }
}
