package p07_Car_Salesman;

public class Engine {
    private static final int DEFAULT_DISPLACEMENT = 0;
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public static Engine parseEngine(String[] engineParams) {
        String model = engineParams[0];
        int power = Integer.parseInt(engineParams[1]);
        int displacement = DEFAULT_DISPLACEMENT;
        String efficiency = DEFAULT_EFFICIENCY;
        switch (engineParams.length) {
            case 4:
                displacement = Integer.parseInt(engineParams[2]);
                efficiency = engineParams[3];
                break;
            case 3:
                try {
                    displacement = Integer.parseInt(engineParams[2]);
                    break;
                } catch (Exception e) {
                    efficiency = engineParams[2];
                    break;
                }
            default:
                break;

        }
        return new Engine(model, power, displacement, efficiency);
    }


    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:" + System.lineSeparator() +
                        "Power: %d" + System.lineSeparator() +
                        "Displacement: %s" + System.lineSeparator() +
                        "Efficiency: %s", this.getModel(), this.getPower()
                , this.getDisplacement() == 0 ? "n/a" : String.valueOf(this.getDisplacement()),
                this.getEfficiency());
    }
}
