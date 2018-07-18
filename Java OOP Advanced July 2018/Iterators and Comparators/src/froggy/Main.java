package froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Lake<Integer> lake = new Lake<>();

        while(!"END".equals(input)){
            List<Integer> tokens = Arrays.stream(input.split("[,\\s]+"))
                    .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));

            lake.addElements(tokens);

            input = scanner.nextLine();
        }
        ArrayList<Integer> output = new ArrayList<>();
        for (Integer integer : lake) {
            output.add(integer);
        }
        System.out.println(output.toString().replaceAll("[\\[\\]]",""));
    }
}
