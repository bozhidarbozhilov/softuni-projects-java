import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> minNumber = (arr)->{
            int minNum = Integer.MAX_VALUE;
            for (Integer integer : arr) {
                if(integer<minNum){
                    minNum = integer;
                }
            }
            return minNum;
        };
        int min = minNumber.apply(numbers);
        System.out.println(min);
    }
}
