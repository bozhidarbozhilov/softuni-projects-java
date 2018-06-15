package p09_Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String element = tokens[1];
            Person currentPerson = new Person(name);
            persons.putIfAbsent(name, currentPerson);

            switch (element) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company currentCompany = new Company(companyName, department, salary);
                    persons.get(name).setCompany(currentCompany);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon currentPokemon = new Pokemon(pokemonName, pokemonType);
                    persons.get(name).addPokemon(currentPokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent currentParent = new Parent(parentName, parentBirthday);
                    persons.get(name).addParent(currentParent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child currentChild = new Child(childName, childBirthday);
                    persons.get(name).addChild(currentChild);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car currentCar = new Car(carModel, carSpeed);
                    persons.get(name).setCar(currentCar);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        String nameToPrint = scanner.nextLine();

        persons.entrySet().stream()
                .filter(name -> name.getKey().equals(nameToPrint))
                .forEach(person -> {
                    System.out.println(person.getKey());
                    System.out.println("Company:");
                    if(person.getValue().getCompany().getName() != null){
                        System.out.println(person.getValue().getCompany().toString());
                    }

                    System.out.println("Car:");
                    if(person.getValue().getCar().getModel() != null){
                        System.out.println(person.getValue().getCar().toString());
                    }

                    System.out.println("Pokemon:");
                    person.getValue().getPokemons().forEach(p -> System.out.println(p.toString()));
                    System.out.println("Parents:");
                    person.getValue().getParents().forEach(parent -> System.out.println(parent.toString()));
                    System.out.println("Children:");
                    person.getValue().getChildren().forEach(child -> System.out.println(child.toString()));
                });
    }
}
