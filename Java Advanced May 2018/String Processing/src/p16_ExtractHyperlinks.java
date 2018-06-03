import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p16_ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder wholeText = new StringBuilder();
        String input = scanner.nextLine();
        Pattern aTag = Pattern.compile("<a[^>]+?>");

        while(!"END".equals(input)){
            wholeText.append(input);
            input = scanner.nextLine();
        }

        List<String> aTags = new ArrayList<>();
        Matcher tag = aTag.matcher(wholeText);
        while(tag.find()){
            aTags.add(tag.group());
        }
        Pattern href = Pattern.compile("href\\s*=\\s*(\\\"([^\"]*\\\")|'[^']*'|([^'\">\\s]+))");

        for (String _aTag : aTags) {
            Matcher link = href.matcher(_aTag);
            if(link.find()){
                String result = link.group(1);
                if(result.startsWith("\"") || result.endsWith("\"")){
                    result = result.replaceAll("\\\"","");
                }else if(result.startsWith("'") || result.endsWith("'")){
                    result = result.replaceAll("'","");
                }
                System.out.println(result);
            }


        }
    }
}
