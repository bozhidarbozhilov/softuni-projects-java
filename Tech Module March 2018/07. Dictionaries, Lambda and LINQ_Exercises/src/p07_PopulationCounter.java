import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class p07_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String,LinkedHashMap<String,Integer>> citiesPopulation = new LinkedHashMap<>();
        LinkedHashMap<String,Long> countryPopulation = new LinkedHashMap<>();

        String[] rawInput = reader.readLine().split("\\|");


        while(!rawInput[0].equals("report")){

            String country = rawInput[1];
            String city = rawInput[0];
            Integer population = Integer.parseInt(rawInput[2]);

            citiesPopulation.putIfAbsent(country, new LinkedHashMap<>());
            citiesPopulation.get(country).put(city,population);

            countryPopulation.putIfAbsent(country,0L);
            countryPopulation.put(country,countryPopulation.get(country)+population);

            rawInput = reader.readLine().split("\\|");
        }

        countryPopulation.entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .forEach(c-> {
                    System.out.printf("%s (total population: %d)%n", c.getKey(), c.getValue());
                    citiesPopulation.get(c.getKey()).entrySet().stream()
                            .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                            .forEach(town-> System.out.printf("=>%s: %d%n", town.getKey(), town.getValue()));

                });
    }
}
