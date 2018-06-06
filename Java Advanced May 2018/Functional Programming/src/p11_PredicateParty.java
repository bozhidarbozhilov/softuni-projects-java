import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p11_PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();
        while (!"Party!".equals(command)) {
            String[] tokens = command.split("\\s+");
            Predicate<String> filter = choosePredicate(tokens[1], tokens[2]);
            List<String> toManipulate = people.stream().filter(e->filter.test(e)).collect(Collectors.toList());
            switch (tokens[0]) {
                case "Remove":
                    people.removeAll(toManipulate);
                    break;
                case "Double":
                    for (String s : toManipulate) {
                        people.add(people.indexOf(s), s);
                    }
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();
        }
        if(!people.isEmpty()){
            System.out.print(String.join(", ", people));
            System.out.println(" are going to the party!");
        }else{
            System.out.println("Nobody is going to the party!");
        }

    }

    private static Predicate<String> choosePredicate(String condition, String parameter) {
        if("StartsWith".equals(condition)){
            return name -> name.startsWith(parameter);
        }else if("EndsWith".equals(condition)){
            return name -> name.endsWith(parameter);
        }else{
            int length = Integer.parseInt(parameter);
            return name -> name.length() == length;
        }
    }
}
