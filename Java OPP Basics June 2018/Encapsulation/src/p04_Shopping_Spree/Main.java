package p04_Shopping_Spree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] peopleIn = scanner.nextLine().split("[;=]");
        for (int i = 0; i < peopleIn.length; i += 2) {
            String name = peopleIn[i];
            Double money = Double.valueOf(peopleIn[i + 1]);
            try {
                people.put(name, new Person(name, money));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }

        }

        String[] productsIn = scanner.nextLine().split("[;=]");

        for (int i = 0; i < productsIn.length; i += 2) {
            String name = productsIn[i];
            Double cost = Double.valueOf(productsIn[i + 1]);
            try {
                products.put(name, new Product(name, cost));
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            Person currentPerson = people.get(tokens[0]);
            Product currentProduct = products.get(tokens[1]);
            if (currentPerson.canAfford(currentProduct)) {
                currentPerson.addProduct(currentProduct);
                currentPerson.decreaseMoney(currentProduct.getCost());
                System.out.printf("%s bought %s%n", currentPerson.getName(), currentProduct.getName());
            } else {
                System.out.printf("%s can't afford %s%n", currentPerson.getName(), currentProduct.getName());
            }
            input = scanner.nextLine();
        }

        people.values().forEach(person -> System.out.println(person.toString()));

    }
}
