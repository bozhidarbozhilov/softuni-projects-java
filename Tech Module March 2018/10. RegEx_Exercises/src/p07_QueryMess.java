import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p07_QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = reader.readLine();

        LinkedHashMap<String,ArrayList<String>> fieldsValues = new LinkedHashMap<>();
        String fieldRegex = "(^|(?<=\\s))([\\*\\.\\-\\w\\s]+)=(.+)$";
        Pattern fieldPattern = Pattern.compile(fieldRegex);
        while(!inputStr.equals("END")){
            String cleanString = cleanString(inputStr);
            String[] separatedStrings = cleanString.split("\\&");
            for (String separatedString : separatedStrings) {
                Matcher valuesMatch = fieldPattern.matcher(separatedString);
                if(valuesMatch.find()){
                    String field = valuesMatch.group(2).trim();
                    String values = valuesMatch.group(3).trim();
                    fieldsValues.putIfAbsent(field,new ArrayList<>());
                    fieldsValues.get(field).add(values);
                }
            }

            fieldsValues.entrySet().stream().forEach(f-> System.out.print(f.getKey()+"="+f.getValue().toString()));
            System.out.println();
            fieldsValues.clear();
            inputStr = reader.readLine();
        }

    }

    private static String cleanString(String inputStr) {

        return inputStr.replaceAll("(%20|\\+|\\?)+"," ");
    }
}
