import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p08_LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countInput = Integer.parseInt(reader.readLine());

        TreeMap<String, TreeSet<String>> userIPs = new TreeMap<>();
        LinkedHashMap<String, Integer> logDuration = new LinkedHashMap<>();

        for (int cnt = 0; cnt < countInput; cnt++) {
            String[] tokens = reader.readLine().split("\\s+");
            String user = tokens[1];
            String currentIP = tokens[0];
            Integer duration = Integer.valueOf(tokens[2]);

            userIPs.putIfAbsent(user, new TreeSet<>());
            if(!userIPs.get(user).contains(currentIP)){
                userIPs.get(user).add(currentIP);
            }
            logDuration.putIfAbsent(user,0);
            logDuration.put(user,logDuration.get(user)+duration);
        }

        userIPs.entrySet()
                .forEach(u->System.out.println(u.getKey()+": " +logDuration.get(u.getKey())+ " "+u.getValue()));
    }
}
