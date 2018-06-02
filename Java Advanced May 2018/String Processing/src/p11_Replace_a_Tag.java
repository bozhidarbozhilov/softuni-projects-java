import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p11_Replace_a_Tag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder();
        String line = scanner.nextLine();
        while(!"END".equals(line)){
            input.append(line).append("\n");
            line = scanner.nextLine();
        }
        String result = input.toString().replaceAll("(<a)(\\s+href[^>]+)(>)(\\s*.*?)(<\\/a>)",
                "[URL$2]$4[/URL]");

        System.out.println(result);
    }
}
