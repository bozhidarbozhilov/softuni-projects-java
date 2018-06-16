package p03_Animal_Farm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("#.##");


        try{
            Chicken chicken = new Chicken(name, age);
            System.out.printf("Chicken %s (age %d) can produce %s eggs per day.",
                    chicken.getName(), chicken.getAge(), df.format(chicken.productPerDay()));
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

    }
}
