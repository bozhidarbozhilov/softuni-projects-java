import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> elements = new TreeSet<>();

        int rowsCnt = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < rowsCnt; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            elements.addAll(Arrays.asList(tokens));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
