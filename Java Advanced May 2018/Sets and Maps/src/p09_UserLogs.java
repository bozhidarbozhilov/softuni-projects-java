import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class p09_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> usersIPs = new TreeMap<>();

        String input = scanner.nextLine();
        while(!"end".equals(input)){
            String[] tokens = input.split("[=\\s]+");
            String ip = tokens[1];
            String user = tokens[5];

            usersIPs.putIfAbsent(user, new LinkedHashMap<>());
            usersIPs.get(user).putIfAbsent(ip, 0);
            usersIPs.get(user).put(ip, usersIPs.get(user).get(ip)+1);

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : usersIPs.entrySet()) {
            LinkedHashMap<String, Integer> ipCnt = entry.getValue();

            System.out.println(entry.getKey()+":");
            System.out.println(ipCnt.entrySet().stream().map(ip -> ip.getKey() + " => " + ip.getValue())
                    .collect(Collectors.joining(", ", "", ".")));
        }
    }
}
