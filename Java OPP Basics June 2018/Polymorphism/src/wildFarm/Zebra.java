package wildFarm.animals;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }
    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

}
