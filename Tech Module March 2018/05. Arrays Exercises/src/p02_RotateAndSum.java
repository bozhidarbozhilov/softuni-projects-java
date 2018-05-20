import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_RotateAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intArray = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf)
                .toArray();
        int rotation = Integer.parseInt(scanner.nextLine());
        int[] sum = new int[intArray.length];
        int n = intArray.length;

        for (int rot = 1; rot <= rotation; rot++) {
            for (int element = 0; element < n; element++) {
                sum[(element+rot)%n] += intArray[element];
            }
        }

        System.out.println(Arrays.stream(sum).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
