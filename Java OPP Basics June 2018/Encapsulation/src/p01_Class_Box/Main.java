package p01_Class_Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Double length = Double.valueOf(scanner.nextLine());
        Double width = Double.valueOf(scanner.nextLine());
        Double height = Double.valueOf(scanner.nextLine());


        try{
            Box box = new Box(length, width, height);
            System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
            System.out.printf("Volume - %.2f%n", box.getVolume());
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }
}
