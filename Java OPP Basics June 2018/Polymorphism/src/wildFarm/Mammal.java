package wildFarm.animals;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#######");
        return String.format("%s[%s, %s, %s, %d]%n",this.getClass().getSimpleName(),
                this.getAnimalName(), df.format(this.getAnimalWeight()),
                this.getLivingRegion(),this.getFoodEaten());
    }
}
