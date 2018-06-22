package p04_Mordors_Cruelty_Plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Food> foods = Arrays.stream(scanner.nextLine().toLowerCase().split("\\s+"))
                .map(Food::new).collect(Collectors.toCollection(ArrayList::new));


        Wizard wizard = new Wizard("Gandalf");

        wizard.addFoods(foods);

        System.out.println(wizard.toString());


    }
}
