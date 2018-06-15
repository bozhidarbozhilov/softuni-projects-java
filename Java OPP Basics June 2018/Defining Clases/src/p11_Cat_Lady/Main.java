package p11_Cat_Lady;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Cat> cats = new ArrayList<>();
        List<Breed> breeds = new ArrayList<>();

        String inputStr = scanner.nextLine();

        while(!"End".equals(inputStr)){
            String[] tokens = inputStr.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double breedParameter = Double.parseDouble(tokens[2]);
            cats.add(new Cat(name));
            breeds.add(new Breed(name, breed, breedParameter));
            inputStr = scanner.nextLine();
        }

        String catToPrint = scanner.nextLine();

        breeds.stream().filter(breed -> breed.getName().equals(catToPrint))
                .forEach(cat -> System.out.println(cat.toString()));
    }
}
