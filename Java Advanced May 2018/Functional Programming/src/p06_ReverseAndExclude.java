import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p06_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int divisor = Integer.parseInt(scanner.nextLine());
        Collections.reverse(nums);
        nums.removeIf(n -> n % divisor == 0);
        System.out.println(nums.toString().replaceAll("[\\[\\],]", ""));
    }
}
