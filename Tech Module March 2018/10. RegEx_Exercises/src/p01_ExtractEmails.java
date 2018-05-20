import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p01_ExtractEmails {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String mailRegex = "(^|(?<=\\s))[A-Za-z0-9]+([\\w\\-\\.]+)@([\\w-]+)\\.([a-z]+)\\.?([a-z]+)?\\b";
        Pattern mailPattern = Pattern.compile(mailRegex);

        String inputStr = reader.readLine();

        Matcher mailMatch = mailPattern.matcher(inputStr);

        while(mailMatch.find()){
            System.out.println(mailMatch.group());
        }

    }
}
