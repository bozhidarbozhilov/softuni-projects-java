import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class p13_SerbianUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> venues = new LinkedHashMap<>();

        Pattern inputPattern = Pattern.compile("(([a-zA-Z]+\\s){1,3})@(([a-zA-Z]+\\s){1,3})(\\d+)\\s(\\d+)");
        String input = scanner.nextLine();
        String singer = "";
        String venue = "";
        long ticketPrice = 0L;
        long ticketCount = 0L;
        long currentIncome = 0L;

        while(!"End".equals(input)){
            Matcher matcherInput = inputPattern.matcher(input);
            if(matcherInput.find()){
                singer = matcherInput.group(1).trim();
                venue = matcherInput.group(3).trim();
                ticketPrice = Long.parseLong(matcherInput.group(5));
                ticketCount = Long.parseLong(matcherInput.group(6));

                currentIncome = ticketCount * ticketPrice;
                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0L);
                venues.get(venue).put(singer, venues.get(venue).get(singer)+currentIncome);
            }
            input = scanner.nextLine();
        }

        venues.entrySet().stream().forEach(v->{
            System.out.println(v.getKey());
            v.getValue().entrySet().stream().sorted((a,b)->b.getValue().compareTo(a.getValue()))
                    .forEach(s-> System.out.printf("#  %s -> %d%n",s.getKey(),s.getValue()));
        });
    }
}
