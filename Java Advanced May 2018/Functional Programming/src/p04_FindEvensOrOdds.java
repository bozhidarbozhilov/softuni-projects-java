import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class p04_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bounds = scanner.nextLine().split("\\s+");
        String command = scanner.nextLine();


        List<Integer> result = new ArrayList<>();
        int lowBound = Integer.parseInt(bounds[0]);
        int upBound = Integer.parseInt(bounds[1]);
        Predicate<Integer> filter = choosePredicate(command);
        for (int i = lowBound; i <= upBound; i++) {
            if(filter.test(i)){
                System.out.print(i+" ");
            }
        }

    }

    private static Predicate<Integer> choosePredicate(String command) {
        if ("even".equals(command)) {
            return (i) -> i % 2 == 0;
        }else{
            return (i) -> i % 2 != 0;
        }
    }

}
