import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p12_ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern emailPattern =
                Pattern.compile("(?<=\\s|^)([a-zA-Z0-9][\\w\\-\\.]+)([\\dA-Za-z])@([A-Za-z0-9][\\w+\\.\\-]*?)" +
                        "(\\.[A-Za-z\\-\\.]*?[A-Za-z])+(?=\\.|,|\\s|$)");



        while(!"end".equals(input)){
            Matcher matcher = emailPattern.matcher(input);
            while(matcher.find()){
                System.out.println(matcher.group());
            }
            input = scanner.nextLine();
        }

    }
}
