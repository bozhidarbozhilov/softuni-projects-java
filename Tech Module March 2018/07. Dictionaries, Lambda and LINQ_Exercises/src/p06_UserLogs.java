import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class p06_UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,LinkedHashMap<String,Integer>> userIpCount = new TreeMap<>();

        String[] rawInput = reader.readLine().split("[= ]");

        while(!rawInput[0].equals("end")){
            String userIP = rawInput[1];
            String userName = rawInput[rawInput.length-1];
            userIpCount.putIfAbsent(userName, new LinkedHashMap<>());
            userIpCount.get(userName).putIfAbsent(userIP,0);
            if(userIpCount.get(userName).containsKey(userIP)){
                userIpCount.get(userName).put(userIP,userIpCount.get(userName).get(userIP)+1);
            }

            rawInput = reader.readLine().split("[= ]");
        }

        userIpCount.entrySet().forEach(user->{
            System.out.printf("%s:%n",user.getKey());
            System.out.println(user.getValue().entrySet().stream()
                    .map(ip -> String.format("%s => %d", ip.getKey(), ip.getValue()))
                    .collect(Collectors.joining(", ", "", ".")));
        });
    }
}
