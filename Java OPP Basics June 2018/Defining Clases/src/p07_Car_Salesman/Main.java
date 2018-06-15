package p07_Car_Salesman;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int engineNumber = Integer.parseInt(scanner.nextLine());

        Set<Engine> engines = new LinkedHashSet<>();

        for (int engine = 0; engine < engineNumber; engine++) {
            String[] engineParams = scanner.nextLine().split("\\s+");
            Engine currentEngine = Engine.parseEngine(engineParams);
            engines.add(currentEngine);
        }

        int carNumber = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();

        while(carNumber-- > 0){
            String[] carParams = scanner.nextLine().split("\\s+");
            String engineMounted = carParams[1];
            Engine engineType = engines.stream()
                    .filter(e->e.getModel().equals(engineMounted))
                    .findFirst().get();
            Car currentCar = Car.parseCar(carParams, engineType);

            cars.add(currentCar);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
