import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p12_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
        List<String> filtered = new ArrayList<>();

        String line = scanner.nextLine();
        while(!"Print".equals(line)){
            String[] tokens = line.split(";");
            String command = tokens[0];
            Predicate<String> filter = chooseFilter(tokens[1], tokens[2]);

            if("Add filter".equals(command)){
                List<String> toFilter = people.stream().filter(e->filter.test(e)).collect(Collectors.toList());
                people.removeAll(toFilter);
                filtered.addAll(toFilter);
            }else{
                List<String> toFilter = filtered.stream().filter(e->filter.test(e)).collect(Collectors.toList());
                filtered.removeAll(toFilter);
                people.addAll(toFilter);
            }
            line = scanner.nextLine();
        }
        System.out.println(people.toString().replaceAll("[\\[\\],]", ""));

    }
    private static Predicate<String> chooseFilter(String condition, String parameter) {
        if("Starts with".equals(condition)){
            return name -> name.startsWith(parameter);
        }else if("Ends with".equals(condition)){
            return name -> name.endsWith(parameter);
        }else if("Length".equals(condition)){
            int length = Integer.parseInt(parameter);
            return name -> name.length() == length;
        }else{
            return name -> name.contains(parameter);
        }
    }
}
