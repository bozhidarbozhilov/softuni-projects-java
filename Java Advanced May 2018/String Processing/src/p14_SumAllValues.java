import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p14_SumAllValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyString = scanner.nextLine();
        Pattern startPattern = Pattern.compile("^[A-Za-z_]+(?=\\d)");
        Pattern endPattern = Pattern.compile("(?<=\\d)[A-Za-z_]+$");
        String startKey = getKey(keyString, startPattern);
        String endKey = getKey(keyString, endPattern);

        String text = scanner.nextLine();

        if(startKey.isEmpty() || endKey.isEmpty()){
            System.out.println("<p>A key is missing</p>");

        }else{
            List<Double> numbers = getNumber(startKey, endKey, text);
            double sum = 0.0;
            for (Double number : numbers) {
                sum += number;
            }
            DecimalFormat df = new DecimalFormat("########.##");
            if(sum != 0.0){
                System.out.printf("<p>The total value is: <em>%s</em></p>", df.format(sum));
            }else{
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        }
    }

    private static ArrayList<Double> getNumber(String start, String end, String text) {
        ArrayList<Double> numbers = new ArrayList<>();
        Pattern pattern = Pattern.compile(String.format("%s\\-?\\d*(\\.?\\d+)?%s", start, end));
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            double num = Double.parseDouble(matcher.group().replace(start,"").replace(end,""));
            numbers.add(num);
        }
        return numbers;
    }

    private static String getKey(String input, Pattern pattern){
        Matcher matcher = pattern.matcher(input);
        String key = "";

        if(matcher.find()){
            key = matcher.group();
        }
        return key;
    }

}
