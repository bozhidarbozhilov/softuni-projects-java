package p05_Speed_Racing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        while(num-- > 0){
            String[] modelParams = scanner.nextLine().split("\\s+");
            String model = modelParams[0];
            double fuelAmount = Double.parseDouble(modelParams[1]);
            double fuelPerKm = Double.parseDouble(modelParams[2]);

            Car currentCar = new Car(model, fuelAmount, fuelPerKm);
            cars.putIfAbsent(model, currentCar);
        }

        String modelCondition = scanner.nextLine();

        while(!"End".equals(modelCondition)){
            String[] tokens = modelCondition.split("\\s+");
            String model = tokens[1];
            double amountOfKms = Double.parseDouble(tokens[2]);

            if(cars.get(model).haveEnoughFuel(amountOfKms)){
                double requiredFuel = cars.get(model).getFuelPerKm() * amountOfKms;
                cars.get(model).setTraveledDistance(amountOfKms);
                cars.get(model).setFuelAmount(requiredFuel);
            }else{
                System.out.println("Insufficient fuel for the drive");
            }
            modelCondition = scanner.nextLine();
        }

        cars.entrySet().stream().forEach(c-> System.out.println(c.getValue()));
    }
}
