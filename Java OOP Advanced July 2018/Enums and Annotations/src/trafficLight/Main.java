package trafficLight;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Light[] inputLights = new Light[input.length];

        for (int i = 0; i < input.length; i++) {
            inputLights[i] = Light.valueOf(input[i]);
        }

        int numsOfIterations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numsOfIterations; i++) {
            for (int j = 0; j < inputLights.length; j++) {
                inputLights[j] = inputLights[j].next();
                System.out.print(inputLights[j]+" ");
            }
            System.out.println();
        }
    }
}
