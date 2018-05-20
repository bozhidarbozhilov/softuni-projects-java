import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p05_KeyReplacer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String keysRegex = "([a-zA-Z]+)([<\\|\\\\])([\\w\\W]+)([<\\|\\\\])([a-zA-z]+)";
        Pattern keys = Pattern.compile(keysRegex);
        String keyString = reader.readLine();
        Matcher keyMatch = keys.matcher(keyString);
        keyMatch.find();
        String start = keyMatch.group(1);
        String end = keyMatch.group(5);

        String textRegex = start+"([\\w]*?)"+end;
        Pattern textPattern = Pattern.compile(textRegex);
        String inputStr = reader.readLine();
        Matcher textMatch = textPattern.matcher(inputStr);

        ArrayList<String> myMatches = new ArrayList<>();
        while(textMatch.find()){
            if(!textMatch.group(1).isEmpty()){
                myMatches.add(textMatch.group(1));
            }

        }

        if(!myMatches.isEmpty()){
            myMatches.forEach(m->System.out.print(m));
        }else{
            System.out.println("Empty result");
        }
    }
}
