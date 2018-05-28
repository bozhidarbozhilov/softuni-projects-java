import java.util.*;

public class p11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cnt = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> logDuration = new TreeMap<>();
        Map<String, Set<String>> userIPs = new LinkedHashMap<>();

        for (int i = 0; i < cnt; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String user = input[1];
            int duration = Integer.parseInt(input[2]);

            logDuration.putIfAbsent(user, 0);
            logDuration.put(user, logDuration.get(user)+duration);

            userIPs.putIfAbsent(user, new TreeSet<>());
            userIPs.get(user).add(ip);
        }

        for (Map.Entry<String, Integer> entry : logDuration.entrySet()) {
            String user = entry.getKey();
            int totalDuration = entry.getValue();
            Set<String> ipList = userIPs.get(user);

            System.out.printf("%s: %d %s%n", user, totalDuration, ipList);
        }
    }
}
