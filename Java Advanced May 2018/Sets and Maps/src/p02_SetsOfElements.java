import java.text.DecimalFormat;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] setSizes = scanner.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(setSizes[0]);
        int secondSetSize = Integer.parseInt(setSizes[1]);

        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextLine());
        }
        StringBuilder result = new StringBuilder();
        for (String symbol : firstSet) {
            if(secondSet.contains(symbol)){
                result.append(symbol).append(" ");
            }

        }
        System.out.println(result.toString());
    }
}
