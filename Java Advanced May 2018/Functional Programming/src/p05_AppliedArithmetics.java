import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p05_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            if ("print".equals(command)) {
                System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
            } else if ("add".equals(command)) {
                numbers = numbers.stream().map(n -> n + 1).collect(Collectors.toList());
            } else if ("multiply".equals(command)) {
                numbers = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
            } else {
                numbers = numbers.stream().map(n -> n - 1).collect(Collectors.toList());
            }

            command = scanner.nextLine();
        }
        System.out.println();
    }
}
