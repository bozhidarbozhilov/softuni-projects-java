import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Ascent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern encrypt = Pattern.compile("(?<=\\w|\\s|\\W|^)([,_])([A-Za-z]+)(\\d)");
        Map<String, String> decoded = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while(!"Ascend".equals(line)){

            for (String key : decoded.keySet()) {
                if(line.contains(key)){
                    line = line.replaceAll(key, decoded.get(key));
                }
            }
            Matcher matcher = encrypt.matcher(line);

            while(matcher.find()){

                StringBuilder sb = new StringBuilder();
                int manipulator = Integer.parseInt(matcher.group(3));
                char[] symbols = matcher.group(2).toCharArray();
                if("_".equals(matcher.group(1))){
                    for (char symbol : symbols) {
                        sb.append((char) (symbol - manipulator));
                    }
                }else if(",".equals(matcher.group(1))){
                    for (char symbol : symbols) {
                        sb.append((char) (symbol + manipulator));
                    }
                }
                decoded.putIfAbsent(matcher.group(),sb.toString());
                line = line.replace(matcher.group(), sb.toString());
            }
            System.out.println(line);
            line = scanner.nextLine();
        }
    }

}
