import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p09_MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^([A-Z][a-z]+) ([A-Z][a-z]+)$");

        String input = scanner.nextLine();
        while(!"end".equals(input)){
            Matcher match = pattern.matcher(input);
            if(match.matches()){
                System.out.println(input);
            }
            input = scanner.nextLine();
        }
    }
}
