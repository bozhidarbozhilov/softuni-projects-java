package p11_Cat_Lady;

public class Breed extends Cat {
    String breedName;
    double breedParameter;

    public Breed(String name,String breedName, double breedParameter) {
        super(name);
        this.breedName = breedName;
        this.breedParameter = breedParameter;
    }

    public String getBreedName() {
        return breedName;
    }

    public double getBreedParameter() {
        return breedParameter;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.breedName, this.getName(), this.breedParameter);
    }
}
