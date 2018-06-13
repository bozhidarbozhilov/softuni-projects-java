package p06_Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] carsData = scanner.nextLine().split("\\s+");
            String model = carsData[0];
            int engineSpeed = Integer.parseInt(carsData[1]);
            int enginePower = Integer.parseInt(carsData[2]);
            int cargoWeight = Integer.parseInt(carsData[3]);
            String cargoType = carsData[4];
            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoType, cargoWeight);

            Car currentCar = new Car(model, currentEngine, currentCargo);
            for (int j = 5; j < carsData.length; j += 2) {
                double currentTyrePresure = Double.parseDouble(carsData[j]);
                int currentTyreAge = Integer.parseInt(carsData[j + 1]);
                Tyre currentTyre = new Tyre(currentTyreAge, currentTyrePresure);
                currentCar.addTyre(currentTyre);
            }
            cars.add(currentCar);
        }
        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                cars.stream()
                        .filter(cargo -> cargo.getCargo().getType().equals(command))
                        .filter(tyres -> tyres.getTyres().stream().filter(pressure -> pressure.getPressure() < 1)
                                .collect(Collectors.toList()).size() > 0)
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            case "flamable":
                cars.stream()
                        .filter(engine -> engine.getEngine().getPower() > 250)
                        .filter(cargo -> cargo.getCargo().getType().equals(command))
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            default:
                break;
        }
    }
}
