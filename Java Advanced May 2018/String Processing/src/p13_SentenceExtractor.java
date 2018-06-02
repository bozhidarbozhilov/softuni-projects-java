import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p13_SentenceExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyWord = scanner.nextLine();
        Pattern sentencePattern = Pattern.compile("[^.!?\\s]?[A-Z0-9][^.!?]*?\\b"+keyWord+"\\b[^.?!]*?[.?!]");
        String input = scanner.nextLine();

        Matcher match = sentencePattern.matcher(input);

        while(match.find()){
            System.out.println(match.group());
        }
    }
}
