import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p03_CameraView {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] conditionNums = Arrays.stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        String inputStr = reader.readLine();

        int toSkip = conditionNums[0];
        int toTake = conditionNums[1];

        ArrayList<String> views = new ArrayList<>();

        String regex = "\\|<([\\w]{"+toSkip+"})([\\w]{0,"+toTake+"})";
        Pattern viewPattern = Pattern.compile(regex);

        Matcher viewMatch = viewPattern.matcher(inputStr);
        while(viewMatch.find()){
            views.add(viewMatch.group(2));
        }
        System.out.println(views.stream().collect(Collectors.joining(", ")));

    }
}
