import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p02_ExtractSentencesByKeyword {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keyWord = reader.readLine();
        String keyRegex = "\\b"+keyWord+"\\b";
        Pattern keyPattern = Pattern.compile(keyRegex);

        String[] inputStr = reader.readLine().split("[?\\.!]");

        for (String sentence : inputStr) {
            Matcher matcher = keyPattern.matcher(sentence);
            if(matcher.find()){
                System.out.println(sentence.trim());
            }
        }
    }
}
