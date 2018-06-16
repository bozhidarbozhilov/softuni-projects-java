package p05_Pizza_Calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaParams = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaParams[1];
        int numberOfToppings = Integer.parseInt(pizzaParams[2]);

        String[] doughParams = scanner.nextLine().split("\\s+");
        String flourType = doughParams[1];
        String bakingTechnique = doughParams[2];
        double weightInGrams = Double.valueOf(doughParams[3]);
        Dough dough = null;
        Pizza pizza = null;
        try{
            pizza = new Pizza(pizzaName, numberOfToppings);

        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }
        try{
            dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        Topping topping = null;
        for (int i = 0; i < numberOfToppings; i++) {
            String[] toppingParams = scanner.nextLine().split("\\s+");
            try{
                topping = new Topping(toppingParams[1], Double.valueOf(toppingParams[2]));
                pizza.addTopping(topping);
            }catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        Double totalPizzaCalories = pizza.calcTotalCalories();

        System.out.printf("%s - %.2f", pizza.getName(), totalPizzaCalories);
    }
}
