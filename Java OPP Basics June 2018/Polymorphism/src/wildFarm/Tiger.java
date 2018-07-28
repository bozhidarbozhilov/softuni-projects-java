package wildFarm.animals;

import wildFarm.foods.Food;

public class Tiger extends Felime {


    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }
    @Override
    public void eat(Food food, int quantity) {
        if(food.getClass().getSimpleName().equals("Meat")){
            this.eat(food, quantity);
        }else{
            System.out.println("Tigers are not eating that type of food!");
        }

    }
    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
