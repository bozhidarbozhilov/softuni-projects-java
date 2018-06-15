package p07_Car_Salesman;

public class Car {
    private static final int DEFAULT_WEIGHT = 0;
    private static final String DEFAULT_COLOUR = "n/a";

    private String model;
    private Engine engine;
    private int weight;
    private String colour;

    public Car(String model, Engine engine, int weight, String colour) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.colour = colour;
    }

    public static Car parseCar(String[] carParams, Engine engineType) {
        String model = carParams[0];
        Engine engine = engineType;
        int weight = DEFAULT_WEIGHT;
        String colour = DEFAULT_COLOUR;

        switch (carParams.length) {
            case 4:
                weight = Integer.parseInt(carParams[2]);
                colour = carParams[3];
                break;
            case 3:
                try {
                    weight = Integer.parseInt(carParams[2]);
                } catch (Exception e) {
                    colour = carParams[2];
                }
                break;
            default:
                break;

        }
        return new Car(model, engine, weight, colour);
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return String.format("%s:"+System.lineSeparator()
        +"%s"+System.lineSeparator()
        +"Weight: %s"+System.lineSeparator()
        +"Color: %s", this.getModel(), this.getEngine(),
                this.getWeight()==0?"n/a":String.valueOf(this.getWeight()),
                this.getColour());
    }
}
