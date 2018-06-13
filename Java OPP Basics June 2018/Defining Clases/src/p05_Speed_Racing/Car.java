package p05_Speed_Racing;

public class Car {
    private static final double DEFAULT_TRAVELED_DISTANCE = 0;

    private String model;
    private double fuelAmount;
    private double fuelPerKm;
    private double traveledDistance;

    public Car(String model, double fuelAmount, double fuelPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelPerKm = fuelPerKm;
        this.traveledDistance = DEFAULT_TRAVELED_DISTANCE;
    }

    public double getTraveledDistance() {
        return traveledDistance;
    }

    public void setTraveledDistance(double traveledDistance) {
        this.traveledDistance += traveledDistance;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelPerKm() {
        return fuelPerKm;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount -= fuelAmount;
    }

    public boolean haveEnoughFuel(double inputDistance){
        return inputDistance * this.fuelPerKm <= this.fuelAmount;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f", this.model, this.fuelAmount, this.traveledDistance);
    }
}
