import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p12_VehiclePark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> availableCars = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
        int counter = 0;

        while (true){
            String input = scanner.nextLine();
            if(input.equals("End of customers!")){
                break;
            }else{
                String[] tokens = input.split("\\s+");
                String carType = tokens[0].substring(0,1).toLowerCase();
                int seatsCount = Integer.parseInt(tokens[2]);
                String demandCar = carType.concat(seatsCount+"");
                if(availableCars.contains(demandCar)){
                    int carPrice = calcPrice(carType, seatsCount);
                    System.out.printf("Yes, sold for %d$\n",carPrice);
                    counter++;
                    availableCars.remove(demandCar);
                }else{
                    System.out.println("No");
                }
            }
        }
        System.out.print("Vehicles left: ");
        System.out.println(availableCars.stream().collect(Collectors.joining(", ")));
        System.out.print("Vehicles sold: "+counter);
    }

    private static int calcPrice(String carType, int seatsCount) {
        return carType.charAt(0)*seatsCount;
    }
}
