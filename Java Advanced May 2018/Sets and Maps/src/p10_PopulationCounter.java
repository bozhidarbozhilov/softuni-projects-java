import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Long> countryPopulation = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Integer>> cityPopulation = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!"report".equals(input)){
            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String city = tokens[0];
            Integer population = Integer.valueOf(tokens[2]);

            countryPopulation.putIfAbsent(country, 0L);
            countryPopulation.put(country, countryPopulation.get(country)+population);
            cityPopulation.putIfAbsent(country,new LinkedHashMap<>());
            cityPopulation.get(country).put(city, population);
            input = scanner.nextLine();
        }

        countryPopulation.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(country->{
                    System.out.printf("%s (total population: %d)%n",country.getKey(),country.getValue());
                    cityPopulation.get(country.getKey()).entrySet().stream()
                            .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                            .forEach(city-> System.out.printf("=>%s: %d%n", city.getKey(),city.getValue()));
                });
    }
}
