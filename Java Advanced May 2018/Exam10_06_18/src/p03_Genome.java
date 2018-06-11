import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p03_Genome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> genomes = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("([a-z!@#$?]+)=(\\d+)--(\\d+)<<([a-z]+)");

        String input = reader.readLine();

        while(!"Stop!".equals(input)){
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){
                String name = matcher.group(1);
                int length = Integer.parseInt(matcher.group(2));
                int count = Integer.parseInt(matcher.group(3));
                String organism = matcher.group(4);
                if(isValidName(name, length)){
                    genomes.putIfAbsent(organism, 0);
                    genomes.put(organism, genomes.get(organism)+count);
                }
            }
            input = reader.readLine();
        }
        genomes.entrySet().stream()
                .sorted((c1,c2)->c2.getValue().compareTo(c1.getValue()))
                .forEach(o-> System.out.println(o.getKey()+" has genome size of " + o.getValue()));
    }

    private static boolean isValidName(String name, int length) {
        name = name.replaceAll("[!@#$?]", "");
        return name.length() == length;
    }
}
