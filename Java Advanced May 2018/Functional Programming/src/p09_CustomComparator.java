import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p09_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers.stream().filter(n-> n%2==0).sorted().collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(n-> n%2!=0).sorted().collect(Collectors.toList());

        evenNumbers.addAll(oddNumbers);
        System.out.println(evenNumbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
