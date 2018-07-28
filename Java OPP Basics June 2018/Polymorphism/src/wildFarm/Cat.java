package wildFarm.animals;

import wildFarm.foods.Food;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String catBreed) {
        super(animalName, animalType, animalWeight,livingRegion);
        this.setBreed(catBreed);
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#######");
        return String.format("%s[%s, %s, %s, %s, %d]%n",this.getClass().getSimpleName(),
                this.getAnimalName(), this.getBreed(),df.format(this.getAnimalWeight()),
                this.getLivingRegion(),this.getFoodEaten());
    }
}
