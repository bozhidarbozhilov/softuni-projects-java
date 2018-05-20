import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p04_Weather {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String weatherRegex = "([A-Z]{2})([\\d]+.[\\d]+)([[a-zA-Z]]+)\\|";
        Pattern weatherPattern = Pattern.compile(weatherRegex);

        String inputStr = reader.readLine();
        LinkedHashMap<String, Double> cityTemp = new LinkedHashMap<>();
        LinkedHashMap<String, String> weatherType = new LinkedHashMap<>();

        while(!inputStr.equals("end")){
            Matcher weatherMatcher = weatherPattern.matcher(inputStr);
            if(weatherMatcher.find()){
                cityTemp.put(weatherMatcher.group(1),Double.valueOf(weatherMatcher.group(2)));
                weatherType.put(weatherMatcher.group(1),weatherMatcher.group(3));

            }

            inputStr = reader.readLine();
        }
        cityTemp.entrySet().stream().sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(c-> System.out.printf("%s => %.2f => %s%n",c.getKey(),c.getValue(),weatherType.get(c.getKey())));
    }
}


