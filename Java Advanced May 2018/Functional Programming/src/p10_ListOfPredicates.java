import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p10_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[] divisorSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Predicate<Integer>> predicates = new ArrayList<>();

        for (int  n : divisorSequence) {
            predicates.add(number -> number % n == 0);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            result.add(i);
        }
        result = result.stream().filter(e->predicates.stream().allMatch(p->p.test(e))).collect(Collectors.toList());
        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
