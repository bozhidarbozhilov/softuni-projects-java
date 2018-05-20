import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String validUserRegex = "(^[a-zA-z][\\w]{2,24})";
        Pattern userPattern = Pattern.compile(validUserRegex);

        String[] userCandidate = reader.readLine().split("[\\s\\\\/\\(\\)]+");

        ArrayList<String> validUsers = new ArrayList<>();


        for (String user : userCandidate) {
            Matcher userMatch = userPattern.matcher(user);
            if(userMatch.matches()){
                validUsers.add(user);
            }
        }
        int sumLenght = 0;
        int maxSum = Integer.MIN_VALUE;
        String firstChoosenString = "";
        String secondChoosenString = "";

        for (int i = 1; i < validUsers.size(); i++) {
            sumLenght = validUsers.get(i-1).length() + validUsers.get(i).length();
            if(sumLenght>maxSum){
                maxSum = sumLenght;
                firstChoosenString = validUsers.get(i-1);
                secondChoosenString = validUsers.get(i);
            }

        }
        System.out.println(firstChoosenString);
        System.out.println(secondChoosenString);
    }
}
