import java.util.Scanner;
import java.util.function.Predicate;

public class p07_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int condition = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> checkName = name -> name.length() <= condition;

        for (String name : names) {
            if(checkName.test(name)){
                System.out.println(name);
            }
        }
    }
}
