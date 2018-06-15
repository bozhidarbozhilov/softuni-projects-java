package p08_Pokemon_Trainer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    private static Map<String, Trainer> trainers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        trainers = new LinkedHashMap<>();

        String inputData = scanner.nextLine();

        while (!"Tournament".equals(inputData)) {
            String[] data = inputData.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String element = data[2];
            int health = Integer.parseInt(data[3]);

            Trainer currentTrainer = new Trainer(trainerName);
            Pokemon currentPokemon = new Pokemon(pokemonName, element, health);


            trainers.putIfAbsent(trainerName, currentTrainer);
            trainers.get(trainerName).addPokemon(currentPokemon);
            inputData = scanner.nextLine();
        }
        String element = scanner.nextLine();

        while (!"End".equals(element)) {
            switch (element) {
                case "Fire":
                    manipulateMap("Fire");
                    break;
                case "Electricity":
                    manipulateMap("Electricity");
                    break;
                case "Water":
                    manipulateMap("Water");
                    break;
                default:
                    break;
            }
            element = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .forEach(System.out::println);
    }

    public static void manipulateMap(String command) {
        trainers.values().stream().forEach(t->{
            if(t.isContainElement(command)){
                t.addBadge();
            }else{
                t.getPokemons().forEach(Pokemon::reduceHealth);
            }
            t.getPokemons().removeIf(p->p.getHealth()<=0);
        });
    }

}
