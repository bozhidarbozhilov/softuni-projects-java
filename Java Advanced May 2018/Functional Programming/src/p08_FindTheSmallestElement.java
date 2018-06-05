import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p08_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());

        Function<List<Integer>,Integer> findMinElement = nums->{
                int minElement = Integer.MAX_VALUE;
                for (int i = 0; i < nums.size();i++) {
                    if(nums.get(i)<=minElement){
                        minElement = nums.get(i);
                    }

                }
                return nums.lastIndexOf(minElement);
        };
        System.out.println(findMinElement.apply(numbers));
    }
}
